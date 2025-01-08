package com.ramki.movie.data.remote

import io.ktor.client.plugins.logging.Logger as KtorLogger
import co.touchlab.kermit.Logger
import com.ramki.movie.BuildConfig
import com.ramki.movie.data.error.toApiError
import com.ramki.movie.data.remote.exception.ApiHttpException
import com.ramki.movie.data.remote.exception.NoInternetConnectionException
import com.ramki.movie.data.remote.model.response.ApiErrorResponse
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.call.body
import io.ktor.client.network.sockets.SocketTimeoutException
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.HttpRequestTimeoutException
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.retry
import io.ktor.client.plugins.timeout
import io.ktor.client.request.request
import io.ktor.serialization.kotlinx.json.json
import kotlinx.io.IOException
import kotlinx.serialization.json.Json

private const val TIMEOUT_SECONDS = 5000L
private const val MAX_RETRIES = 3
private const val PARAM_API_KEY = "api_key"

val httpClient = HttpClient {
    expectSuccess = true
    engineConfig()
    loggerConfig()
    jsonConfig()
    errorHandlerConfig()
    defaultRequestConfig()
}

private fun HttpClientConfig<*>.engineConfig() {
    engine {
        request {
            timeout {
                requestTimeoutMillis = TIMEOUT_SECONDS
            }
            retry {
                retryOnExceptionOrServerErrors(maxRetries = MAX_RETRIES)
            }
        }
    }
}

private fun HttpClientConfig<*>.loggerConfig() {
    install(Logging) {
        level = LogLevel.ALL
        logger = object : KtorLogger {
            override fun log(message: String) {
                Logger.i { message }
            }
        }
    }
}

private fun HttpClientConfig<*>.jsonConfig() {
    install(ContentNegotiation) {
        json(
            json = Json {
                ignoreUnknownKeys = true
                prettyPrint = true
                explicitNulls = false
                isLenient = true
            }
        )
    }
}

private fun HttpClientConfig<*>.errorHandlerConfig() {
    HttpResponseValidator {
        handleResponseExceptionWithRequest { cause, _ ->
            Logger.e { cause.message.toString() }
            when (cause) {
                is IOException,
                is SocketTimeoutException,
                is HttpRequestTimeoutException -> throw NoInternetConnectionException

                is ClientRequestException -> {
                    val response = cause.response
                    val errorBody = response.body<String>()
                    val errorResponse = Json.decodeFromString<ApiErrorResponse>(errorBody)
                    throw ApiHttpException(
                        error = errorResponse.toApiError(),
                        httpCode = response.status.value,
                        httpMessage = errorResponse.message
                    )
                }

                else -> throw cause
            }
        }
    }
}

private fun HttpClientConfig<*>.defaultRequestConfig() {
    defaultRequest {
        url(BuildConfig.BASE_URL)
        url.parameters.append(PARAM_API_KEY, "${BuildConfig.API_KEY}1")
    }
}

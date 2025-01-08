package com.ramki.movie.data.remote.exception

import com.ramki.movie.data.error.ApiError

object NoInternetConnectionException : RuntimeException()

data class ApiHttpException(
    val error: ApiError?,
    val httpCode: Int,
    val httpMessage: String?
) : RuntimeException()

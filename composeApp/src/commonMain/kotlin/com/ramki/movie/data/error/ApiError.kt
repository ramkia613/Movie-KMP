package com.ramki.movie.data.error

import com.ramki.movie.data.remote.model.response.ApiErrorResponse

data class ApiError(
    val message: String,
    val code: String,
)

fun ApiErrorResponse.toApiError(): ApiError {
    return ApiError(
        message = this.message,
        code = this.code.toString()
    )
}

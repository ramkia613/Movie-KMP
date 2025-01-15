package com.ramki.movie.data.error

import com.ramki.movie.data.remote.model.response.ApiErrorResponse

data class AppError(
    val message: String,
    val code: String,
)

fun ApiErrorResponse.toAppError(): AppError {
    return AppError(
        message = this.message,
        code = this.code.toString()
    )
}

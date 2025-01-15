package com.ramki.movie.data.remote.exception

import com.ramki.movie.data.error.AppError

object NoInternetConnectionException : RuntimeException()

data class AppException(
    val error: AppError,
    val code: String,
) : RuntimeException()

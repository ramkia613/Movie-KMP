package com.ramki.movie.data.error

open class AppError(
    override val cause: Throwable?,
    override val message: String? = null,
) : Throwable(message, cause)

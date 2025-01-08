package com.ramki.movie.data.error

open class AppError(
    override val cause: Throwable?,
    open val readableMessage: String? = null,
) : Throwable(readableMessage, cause)

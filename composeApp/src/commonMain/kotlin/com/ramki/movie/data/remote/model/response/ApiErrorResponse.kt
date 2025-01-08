package com.ramki.movie.data.remote.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiErrorResponse(
    @SerialName("status_code")
    val code: Int,
    @SerialName("status_message")
    val message: String,
    @SerialName("success")
    val success: Boolean
)

package com.joaoferreira.techchallenge.allapps.domain.response

import com.google.gson.annotations.SerializedName

/**
 * Data class for API json
 */
data class ApiResponse(
    @SerializedName("status") val status: String,
    @SerializedName("responses") val responses: ResponseData
)

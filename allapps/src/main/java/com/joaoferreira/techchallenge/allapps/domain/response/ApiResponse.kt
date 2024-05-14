package com.joaoferreira.techchallenge.allapps.domain.response

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("status") val status: String,
    @SerializedName("responses") val responses: ResponseData
)

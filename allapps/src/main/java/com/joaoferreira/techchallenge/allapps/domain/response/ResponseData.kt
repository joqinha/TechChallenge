package com.joaoferreira.techchallenge.allapps.domain.response

import com.google.gson.annotations.SerializedName

data class ResponseData(
    @SerializedName("listApps") val listApps: ListAppsResponse
)
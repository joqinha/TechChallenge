package com.joaoferreira.techchallenge.allapps.domain

import com.google.gson.annotations.SerializedName
import java.util.ArrayList

data class ApiResponse(
    @SerializedName("status") val status: String,
    @SerializedName("responses") val responses: ResponseData
)

data class ResponseData(
    @SerializedName("listApps") val listApps: ListAppsResponse
)

data class ListAppsResponse(
    @SerializedName("datasets") val datasets: Datasets,
)

data class Datasets(
    @SerializedName("all") val all: AllApps
)

data class AllApps(
    @SerializedName("data") val data: AllAppsDataList
)

data class AllAppsDataList(
    @SerializedName("list") val list: List<AppData>
)

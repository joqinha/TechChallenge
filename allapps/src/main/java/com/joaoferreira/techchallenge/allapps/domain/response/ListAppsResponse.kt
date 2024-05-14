package com.joaoferreira.techchallenge.allapps.domain.response

import com.google.gson.annotations.SerializedName

data class ListAppsResponse(
    @SerializedName("datasets") val datasets: Datasets,
)
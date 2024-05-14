package com.joaoferreira.techchallenge.allapps.domain.response

import com.google.gson.annotations.SerializedName

data class AllApps(
    @SerializedName("data") val data: AllAppsDataList
)
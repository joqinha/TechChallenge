package com.joaoferreira.techchallenge.allapps.domain.response

import com.google.gson.annotations.SerializedName

/**
 * Data class for API json
 */
data class AllApps(
    @SerializedName("data") val data: AllAppsDataList
)

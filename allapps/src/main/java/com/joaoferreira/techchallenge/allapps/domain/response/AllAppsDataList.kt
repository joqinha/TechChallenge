package com.joaoferreira.techchallenge.allapps.domain.response

import com.google.gson.annotations.SerializedName

/**
 * Data class for API json
 */
data class AllAppsDataList(
    @SerializedName("list") val list: List<AppData>
)

package com.joaoferreira.techchallenge.allapps.domain.response

import com.google.gson.annotations.SerializedName

data class Datasets(
    @SerializedName("all") val all: AllApps
)
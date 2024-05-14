package com.joaoferreira.techchallenge.allapps.domain

/**
 * Data class that will be used in the app
 */
data class AppDetails(
    val id: Long,
    val name: String,
    val versionName: String,
    val size: Long,
    val downloads: Long,
    val rating: Double,
    val iconUrl: String,
    val graphicUrl: String?,
)

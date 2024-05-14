package com.joaoferreira.techchallenge.allapps.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class AppDetailsTest {

    @Test
    @DisplayName(
        "GIVEN AppDetails " +
            "WHEN creating a AppDetails " +
            "THEN the values should match"
    )
    fun testAppDetails() {
        val id = 123L
        val name = "Test App"
        val versionName = "1.0"
        val size = 1024L
        val downloads = 100L
        val rating = 4.5
        val iconUrl = "https://example.com/icon.png"
        val graphicUrl = "https://example.com/graphic.png"

        val appDetails =
            AppDetails(id, name, versionName, size, downloads, rating, iconUrl, graphicUrl)

        assertEquals(id, appDetails.id)
        assertEquals(name, appDetails.name)
        assertEquals(versionName, appDetails.versionName)
        assertEquals(size, appDetails.size)
        assertEquals(downloads, appDetails.downloads)
        assertEquals(rating, appDetails.rating)
        assertEquals(iconUrl, appDetails.iconUrl)
        assertEquals(graphicUrl, appDetails.graphicUrl)
    }
}

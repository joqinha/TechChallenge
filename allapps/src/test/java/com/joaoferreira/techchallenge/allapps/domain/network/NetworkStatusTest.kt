package com.joaoferreira.techchallenge.allapps.domain.network

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class NetworkStatusTest {

    @Test
    @DisplayName(
        "GIVEN NetworkStatus " +
            "WHEN creating a NetworkStatus " +
            "THEN the values should match"
    )
    fun testNetworkStatus() {
        val initial = NetworkStatus.INITIAL
        val available = NetworkStatus.AVAILABLE
        val losing = NetworkStatus.LOSING
        val lost = NetworkStatus.LOST
        val unavailable = NetworkStatus.UNAVAILABLE
        val capabilitiesChanged = NetworkStatus.CAPABILITIES_CHANGED
        val linkPropertiesChanged = NetworkStatus.LINK_PROPERTIES_CHANGED
        val blockedStatusChanged = NetworkStatus.BLOCKED_STATUS_CHANGED

        assertEquals("INITIAL", initial.name)
        assertEquals("AVAILABLE", available.name)
        assertEquals("LOSING", losing.name)
        assertEquals("LOST", lost.name)
        assertEquals("UNAVAILABLE", unavailable.name)
        assertEquals("CAPABILITIES_CHANGED", capabilitiesChanged.name)
        assertEquals("LINK_PROPERTIES_CHANGED", linkPropertiesChanged.name)
        assertEquals("BLOCKED_STATUS_CHANGED", blockedStatusChanged.name)

        assertEquals(NetworkStatus.INITIAL, NetworkStatus.valueOf("INITIAL"))
        assertEquals(NetworkStatus.AVAILABLE, NetworkStatus.valueOf("AVAILABLE"))
        assertEquals(NetworkStatus.LOSING, NetworkStatus.valueOf("LOSING"))
        assertEquals(NetworkStatus.LOST, NetworkStatus.valueOf("LOST"))
        assertEquals(NetworkStatus.UNAVAILABLE, NetworkStatus.valueOf("UNAVAILABLE"))
        assertEquals(
            NetworkStatus.CAPABILITIES_CHANGED,
            NetworkStatus.valueOf("CAPABILITIES_CHANGED")
        )
        assertEquals(
            NetworkStatus.LINK_PROPERTIES_CHANGED,
            NetworkStatus.valueOf("LINK_PROPERTIES_CHANGED")
        )
        assertEquals(
            NetworkStatus.BLOCKED_STATUS_CHANGED,
            NetworkStatus.valueOf("BLOCKED_STATUS_CHANGED")
        )

        assertEquals(8, NetworkStatus.values().size)
    }
}

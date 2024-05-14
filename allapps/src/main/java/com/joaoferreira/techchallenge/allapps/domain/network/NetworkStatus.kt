package com.joaoferreira.techchallenge.allapps.domain.network

enum class NetworkStatus {
    INITIAL,
    AVAILABLE,
    LOSING,
    LOST,
    UNAVAILABLE,
    CAPABILITIES_CHANGED,
    LINK_PROPERTIES_CHANGED,
    BLOCKED_STATUS_CHANGED;
}
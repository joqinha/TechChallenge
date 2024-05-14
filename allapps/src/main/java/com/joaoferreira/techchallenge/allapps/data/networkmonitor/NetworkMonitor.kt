package com.joaoferreira.techchallenge.allapps.data.networkmonitor

import com.joaoferreira.techchallenge.allapps.domain.network.NetworkStatus
import kotlinx.coroutines.flow.StateFlow

interface NetworkMonitor {
    val networkStatus: StateFlow<NetworkStatus>
}

package com.joaoferreira.techchallenge.allapps.data.networkmonitor

import android.content.Context
import android.net.ConnectivityManager
import android.net.LinkProperties
import android.net.Network
import android.net.NetworkCapabilities
import com.joaoferreira.techchallenge.allapps.domain.network.NetworkStatus
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class NetworkMonitorImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : NetworkMonitor {

    private val _networkStatus = MutableStateFlow(NetworkStatus.INITIAL)
    override val networkStatus = _networkStatus.asStateFlow()

    init {
        checkConnectivity()
    }

    private fun checkConnectivity() {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkCallback = object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                super.onAvailable(network)
                _networkStatus.value = NetworkStatus.AVAILABLE
            }

            override fun onLost(network: Network) {
                super.onLost(network)
                _networkStatus.value = NetworkStatus.LOST
            }

            override fun onLosing(network: Network, maxMsToLive: Int) {
                super.onLosing(network, maxMsToLive)
                _networkStatus.value = NetworkStatus.LOSING
            }

            override fun onUnavailable() {
                super.onUnavailable()
                _networkStatus.value = NetworkStatus.UNAVAILABLE
            }

            override fun onCapabilitiesChanged(
                network: Network,
                networkCapabilities: NetworkCapabilities
            ) {
                super.onCapabilitiesChanged(network, networkCapabilities)
                _networkStatus.value = NetworkStatus.CAPABILITIES_CHANGED
            }

            override fun onLinkPropertiesChanged(network: Network, linkProperties: LinkProperties) {
                super.onLinkPropertiesChanged(network, linkProperties)
                _networkStatus.value = NetworkStatus.LINK_PROPERTIES_CHANGED
            }

            override fun onBlockedStatusChanged(network: Network, blocked: Boolean) {
                super.onBlockedStatusChanged(network, blocked)
                _networkStatus.value = NetworkStatus.BLOCKED_STATUS_CHANGED
            }
        }
        connectivityManager.registerDefaultNetworkCallback(networkCallback)
    }
}
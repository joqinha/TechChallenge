package com.joaoferreira.techchallenge.allapps.di

import android.content.Context
import com.joaoferreira.techchallenge.allapps.data.networkmonitor.NetworkMonitor
import com.joaoferreira.techchallenge.allapps.data.networkmonitor.NetworkMonitorImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Module that provides instances of dependencies related with Network observer
 */
@Module
@InstallIn(SingletonComponent::class)
class NetworkMonitorModule {
    /**
     * Provides an instance of NetworkMonitor
     */
    @Provides
    @Singleton
    fun provideNetworkMonitor(@ApplicationContext context: Context): NetworkMonitor {
        return NetworkMonitorImpl(context)
    }
}

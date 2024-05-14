package com.joaoferreira.techchallenge.allapps.di

import com.joaoferreira.techchallenge.allapps.data.ApiService
import com.joaoferreira.techchallenge.allapps.data.AppsRepository
import com.joaoferreira.techchallenge.allapps.data.AppsRepositoryImpl
import com.joaoferreira.techchallenge.allapps.data.localdatabase.AppDao
import com.joaoferreira.techchallenge.allapps.data.networkmonitor.NetworkMonitor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Module that provides instances of dependencies related with Apps repository.
 */
@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    /**
     * Provides an instance of AppsRepository
     */
    @Singleton
    @Provides
    fun provideAppsRepository(
        apiService: ApiService,
        appDao: AppDao,
        networkMonitor: NetworkMonitor
    ): AppsRepository = AppsRepositoryImpl(apiService, appDao, networkMonitor)
}

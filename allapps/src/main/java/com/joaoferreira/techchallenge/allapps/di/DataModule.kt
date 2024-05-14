package com.joaoferreira.techchallenge.allapps.di

import android.content.Context
import android.net.ConnectivityManager
import androidx.room.Room
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.joaoferreira.techchallenge.allapps.data.ApiService
import com.joaoferreira.techchallenge.allapps.data.localdatabase.AppDao
import com.joaoferreira.techchallenge.allapps.data.AppsRepository
import com.joaoferreira.techchallenge.allapps.data.AppsRepositoryImpl
import com.joaoferreira.techchallenge.allapps.data.localdatabase.AppDatabase
import com.joaoferreira.techchallenge.allapps.data.networkmonitor.NetworkMonitor
import com.joaoferreira.techchallenge.allapps.data.networkmonitor.NetworkMonitorImpl
import com.joaoferreira.techchallenge.allapps.domain.network.NetworkStatus
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Singleton
    @Provides
    fun provideAppsRepository(
        apiService: ApiService,
        appDao: AppDao,
        networkMonitor: NetworkMonitor
    ): AppsRepository = AppsRepositoryImpl(apiService, appDao, networkMonitor)
}

package com.joaoferreira.techchallenge.allapps.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.joaoferreira.techchallenge.allapps.data.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier

@Suppress("UndocumentedPublicClass")
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BaseUrl

/**
 * Module that provides instances of dependencies related with API service.
 */
@Module
@InstallIn(SingletonComponent::class)
class ApiModule {
    /**
     * Provides an instance of BaseUrl
     */
    @Suppress("FunctionOnlyReturningConstant")
    @Provides
    @BaseUrl
    fun provideBaseUrl(): String = "https://ws2.aptoide.com/"

    /**
     * Provides an instance of Gson
     */
    @Provides
    fun provideGson(): Gson = GsonBuilder().setLenient().create()

    /**
     * Provides an instance of HttpLoggingInterceptor
     */
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    /**
     * Provides an instance of OkHttpClinet
     */
    @Provides
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    /**
     * Provides an instance of Retrofit
     */
    @Provides
    fun provideRetrofit(
        @BaseUrl baseUrl: String,
        gson: Gson,
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    /**
     * Provides an instance of ApiService
     */
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}

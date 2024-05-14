package com.joaoferreira.techchallenge.di

import android.content.Context
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import com.joaoferreira.techchallenge.domain.notification.NotificationWorker
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Module that provides instances of dependencies related with periodic notification.
 */
@Module
@InstallIn(SingletonComponent::class)
class WorkerModule {
    /**
     * Provides an instance of NotificationWorker
     */
    @Singleton
    @Provides
    fun provideNotificationWorkerFactory(
        @ApplicationContext appContext: Context,
        workerParams: WorkerParameters
    ): NotificationWorker {
        return NotificationWorker(appContext, workerParams)
    }

    /**
     * Provides an instance of WorkerFactory
     */
    @Singleton
    @Provides
    fun provideWorkerFactory(
        workerFactory: HiltWorkerFactory
    ): WorkerFactory {
        return workerFactory
    }
}

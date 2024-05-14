package com.joaoferreira.techchallenge.domain.notification

import androidx.work.Configuration
import androidx.work.WorkerFactory
import javax.inject.Inject

/**
 * Notification Worker Factory
 */
class NotificationWorkerFactory @Inject constructor(
    private val workerFactory: WorkerFactory
) : Configuration.Provider {
    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()
    }
}

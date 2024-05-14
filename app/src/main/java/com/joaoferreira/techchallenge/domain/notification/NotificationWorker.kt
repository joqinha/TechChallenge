package com.joaoferreira.techchallenge.domain.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.joaoferreira.techchallenge.R
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

/**
 * Notification Worker
 */
class NotificationWorker @Inject constructor(
    @ApplicationContext appContext: Context,
    workerParams: WorkerParameters
) : Worker(appContext, workerParams) {

    companion object {
        const val CHANNEL_ID = "new_apps_channel"
        const val CHANNEL_NAME = "New Apps"
        const val NOTIFICATION_ID = 1
    }

    override fun doWork(): Result {
        showNotification()
        return Result.success()
    }

    private fun showNotification() {
        createNotificationChannel()

        val notification = NotificationCompat.Builder(applicationContext, CHANNEL_ID)
            .setContentTitle("Aptoide News")
            .setContentText("Open Aptoide to download the newest apps")
            .setSmallIcon(R.drawable.aptoide_logo)
            .build()

        val notificationManager =
            applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(NOTIFICATION_ID, notification)
    }

    private fun createNotificationChannel() {
        val channelId = CHANNEL_ID
        val channelName = CHANNEL_NAME
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(channelId, channelName, importance)

        val notificationManager = applicationContext.getSystemService(
            Context.NOTIFICATION_SERVICE
        ) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }
}

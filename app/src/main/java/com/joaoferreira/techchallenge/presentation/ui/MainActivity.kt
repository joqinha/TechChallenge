package com.joaoferreira.techchallenge.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.joaoferreira.techchallenge.domain.notification.NotificationWorker
import com.joaoferreira.techchallenge.presentation.ui.compose.MainApp
import com.joaoferreira.techchallenge.utils.AppConstants.DELAY_BETWEEN_NOTIFICATIONS
import dagger.hilt.android.AndroidEntryPoint
import java.util.concurrent.TimeUnit

/**
 * MainActivity
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Surface(modifier = Modifier.fillMaxSize(), color = Color.Transparent) {
                MainApp()
            }
        }

        periodicWorker()
    }

    private fun periodicWorker() {
        val periodicWorkRequest = PeriodicWorkRequestBuilder<NotificationWorker>(
            repeatInterval = DELAY_BETWEEN_NOTIFICATIONS,
            TimeUnit.MINUTES
        ).setInitialDelay(DELAY_BETWEEN_NOTIFICATIONS, TimeUnit.MINUTES).build()
        WorkManager.getInstance(this).enqueue(periodicWorkRequest)
    }
}

package com.nayan.foregroundservice.application

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.annotation.RequiresApi


public class App : Application() {

    companion object {
        const val CHANNEL_ID = "ForgroundServiceDemo"
    }

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            var serviceChannel = NotificationChannel(
                CHANNEL_ID,
                "Forground Service Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )

            var manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(serviceChannel)
        }

    }


}
package com.nayan.foregroundservice.service

import android.R
import android.app.Notification
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.nayan.foregroundservice.MainActivity
import com.nayan.foregroundservice.application.App
import com.nayan.foregroundservice.application.App.Companion.CHANNEL_ID


class ForgroundService : Service() {

    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        val input = intent?.getStringExtra("input")

        val intent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Forground Service Demo")
            .setContentText(input)
            .setSmallIcon(R.drawable.sym_def_app_icon)
            .setContentIntent(pendingIntent)
            .build()

        // if we does not show notification then service will automatically stop within 1 min
        startForeground(1, notification)

        return START_NOT_STICKY

    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}
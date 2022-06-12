package com.example.task10

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.Settings
import android.util.Log

private const val B_TAG = "BROADCAST RECEIVER"

class MyBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        val turned_on : Boolean = Settings.Global.getInt(context?.contentResolver, Settings.Global.AIRPLANE_MODE_ON, 0) != 0;

        if (context != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val importance = NotificationManager.IMPORTANCE_DEFAULT

                val channel = NotificationChannel(NotificationUtil.CHANNEL_ID, NotificationUtil.CHANNEL_ID, importance).apply {
                    description = B_TAG
                }

                val notify_manager: NotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                notify_manager.createNotificationChannel(channel)
            }

            if (turned_on) {
                NotificationUtil.showSimpleNotification(context, "TURNED ON")
            } else {
                NotificationUtil.showSimpleNotification(context, "TURNED OFF")
            }
        }

    }
}
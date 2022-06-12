package com.example.task10

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat

object NotificationUtil {
    const val CHANNEL_ID = "CHANELL_ID"

    fun showSimpleNotification(context: Context, text: String) {
        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_baseline_ac_unit_24)
            .setContentTitle("AIR_PLANE")
            .setContentText(text)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(1, notification.build())
    }
}
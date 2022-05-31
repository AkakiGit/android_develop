package com.example.task9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val worker1 = OneTimeWorkRequestBuilder<WorkerOne>()
            .build()

        val worker2 = OneTimeWorkRequestBuilder<WorkerTwo>()
            .build()

        WorkManager.getInstance(this)
            .beginWith(worker1)
            .then(worker2)
            .enqueue()
    }
}
package com.example.task9

import android.content.Context
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters

class WorkerOne(ctx: Context, params: WorkerParameters) : Worker(ctx, params) {
    override fun doWork(): Result {

        doSomethingWorkerOne(this.javaClass.name);

        val myText = "info text";

        val data = Data.Builder()
            .putString("KEY", myText)
            .build()

        return Result.success(data);
    }
}
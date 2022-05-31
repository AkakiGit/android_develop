package com.example.task9

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class WorkerTwo(ctx: Context, params: WorkerParameters) : Worker(ctx, params) {
    override fun doWork(): Result {

        doSomethingWorkerTwo(this.javaClass.name);

        val infoText = inputData.getString("KEY");

        println(infoText)

        return Result.success();
    }
}
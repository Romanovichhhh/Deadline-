package com.example.mvvmplayer.features.worker

import android.content.Context
import androidx.work.*
import androidx.work.WorkerFactory
import com.example.mvvmplayer.features.domain.repository.IPreferences

class DaggerWorkerFactory(val iPreferences: IPreferences) : WorkerFactory() {

    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker? {
        val workKlass = Class.forName(workerClassName).asSubclass(Worker::class.java)
        val constructor =
            workKlass.getDeclaredConstructor(Context::class.java, WorkerParameters::class.java)
        return constructor.newInstance(appContext, workerParameters)
    }
}
package com.example.mvvmplayer.app

import android.app.Application
import com.example.mvvmplayer.di.component.DaggerAppComponent
import com.example.mvvmplayer.features.worker.DaggerWorkerFactory
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class App : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var daggerWorkerFactory: DaggerWorkerFactory

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent
            .builder()
            .application(this)
            .build()
            .inject(this)

//        val config = Configuration.Builder()
//            .setWorkerFactory(daggerWorkerFactory)
//            .build()
//        WorkManager.initialize(this, config)
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}
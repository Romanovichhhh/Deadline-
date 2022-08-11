package com.example.mvvmplayer.di.module

import com.example.mvvmplayer.features.domain.repository.IPreferences
import com.example.mvvmplayer.features.worker.DaggerWorkerFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class WorkerFactoryInjectionsModule {

    @Provides
    @Singleton
    fun workerFactory(
        preferences: IPreferences
    ) : DaggerWorkerFactory = DaggerWorkerFactory(preferences)
}
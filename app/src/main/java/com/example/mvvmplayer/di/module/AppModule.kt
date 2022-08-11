package com.example.mvvmplayer.di.module

import android.content.Context
import com.example.mvvmplayer.app.App
import com.example.mvvmplayer.features.domain.repository.IPreferences
import com.example.mvvmplayer.features.domain.repository.PreferencesImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideApplicationContext(app: App) : Context = app.applicationContext

    @Provides
    @Singleton
    fun providePreferences(context : Context) : IPreferences = PreferencesImpl(context)
}
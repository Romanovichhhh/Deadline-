package com.example.mvvmplayer.di.module

import com.example.mvvmplayer.app.MainActivity
import com.example.mvvmplayer.app.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentActivityInjectionsModule {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun mainActivityInjector() : MainActivity
}
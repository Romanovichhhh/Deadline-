package com.example.mvvmplayer.app

import com.example.mvvmplayer.di.Provider
import com.example.mvvmplayer.di.qualifier.ViewModelInjection
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    @ViewModelInjection
    fun provideMainActivityViewModel (
        activity: MainActivity,
        viewModelProvider : Provider<MainActivityViewModel>
    ): MainActivityViewModel = viewModelProvider.get(activity, MainActivityViewModel::class)
}
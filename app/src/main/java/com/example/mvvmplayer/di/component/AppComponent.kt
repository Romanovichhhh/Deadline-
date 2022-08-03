package com.example.mvvmplayer.di.component

import com.example.mvvmplayer.app.App
import com.example.mvvmplayer.di.module.AppModule
import com.example.mvvmplayer.di.module.FragmentActivityInjectionsModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        FragmentActivityInjectionsModule::class,
        AppModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: App) : Builder

        fun build() : AppComponent
    }

    fun inject(application: App)
}
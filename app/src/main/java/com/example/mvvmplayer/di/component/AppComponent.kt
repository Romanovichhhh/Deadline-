package com.example.mvvmplayer.di.component

import com.example.mvvmplayer.app.App
import com.example.mvvmplayer.di.module.ActivityInjectionsModule
import com.example.mvvmplayer.di.module.AppModule
import com.example.mvvmplayer.di.module.FragmentInjectionsModule
import com.example.mvvmplayer.di.module.WorkerFactoryInjectionsModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityInjectionsModule::class,
        AppModule::class,
        FragmentInjectionsModule::class,
        WorkerFactoryInjectionsModule::class
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
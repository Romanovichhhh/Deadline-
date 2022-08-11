package com.example.mvvmplayer.di.module

import com.example.mvvmplayer.di.qualifier.ScreenScope
import com.example.mvvmplayer.features.presentation.pincode.PinCodeFragment
import com.example.mvvmplayer.features.presentation.pincode.PinCodeFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentInjectionsModule {

    @ScreenScope
    @ContributesAndroidInjector(modules = [PinCodeFragmentModule::class])
    abstract fun pinCodeFragmentInjector() : PinCodeFragment
}
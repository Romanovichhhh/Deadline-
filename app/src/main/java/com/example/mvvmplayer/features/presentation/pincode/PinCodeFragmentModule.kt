package com.example.mvvmplayer.features.presentation.pincode

import com.example.mvvmplayer.di.Provider
import com.example.mvvmplayer.di.qualifier.ViewModelInjection
import dagger.Module
import dagger.Provides

@Module
class PinCodeFragmentModule {

    @Provides
    @ViewModelInjection
    fun providePinCodeFragment (
        fragment : PinCodeFragment,
        viewModelProvider : Provider<PinCodeFragmentViewModel>
    ): PinCodeFragmentViewModel = viewModelProvider.get(fragment, PinCodeFragmentViewModel::class)
}
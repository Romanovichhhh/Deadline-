package com.example.mvvmplayer.app.fragment

import com.example.mvvmplayer.app.viewmodel.BaseViewModel
import dagger.android.support.DaggerFragment
abstract class BaseFragment<VM : BaseViewModel> : DaggerFragment() {

    lateinit var viewModel : VM

}
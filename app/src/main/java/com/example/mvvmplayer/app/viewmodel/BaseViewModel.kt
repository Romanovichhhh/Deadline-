package com.example.mvvmplayer.app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel() : ViewModel() {

    private val progress = MutableLiveData<Boolean>()
    private val error = MutableLiveData<Throwable>()

    val errorLiveData: LiveData<Throwable>
        get() = error
    val progressLiveData: LiveData<Boolean>
        get() = progress

    protected fun showError(throwable: Throwable) {
        error.value = throwable
    }

    protected fun showProgress(show: Boolean) {
        progress.value = show
    }

    open fun refresh() {
        // nothing by default
    }
}
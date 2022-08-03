package com.example.mvvmplayer.features.presentation.pincode

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mvvmplayer.R
import com.example.mvvmplayer.app.fragment.BaseFragment
import com.example.mvvmplayer.databinding.FragmentPinCodeBinding

class PinCodeFragment : BaseFragment<FragmentPinCodeBinding, PinCodeFragmentViewModel>() {


    override fun layoutRes() = R.layout.fragment_pin_code

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}


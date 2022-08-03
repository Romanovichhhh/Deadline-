package com.example.mvvmplayer.app.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.fragment.findNavController
import com.example.mvvmplayer.app.viewmodel.BaseViewModel
import com.example.mvvmplayer.di.qualifier.ViewModelInjection
import com.example.mvvmplayer.util.extensions.safePopBackStack
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseFragment<BINDING : ViewDataBinding, VM : BaseViewModel> : DaggerFragment() {

    @Inject
    @ViewModelInjection
    lateinit var viewModel: VM

    private var _binding: BINDING? = null
    val binding get() = _binding!!

    @LayoutRes
    abstract fun layoutRes(): Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, layoutRes(), container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.onBackPressedDispatcher?.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    onBackPressed()
                }
            }
        )
        observe()
    }

    fun observe() {
        viewModel.errorLiveData.observe(
            viewLifecycleOwner
        ) {
            //TODO Придумать и нарисовать лоадер
        }
        viewModel.progressLiveData.observe(
            viewLifecycleOwner
        ) {
            //TODO Придумать и нарисовать лоадер
        }
    }

    open fun onBackPressed() {
        if (findNavController().safePopBackStack().not()) {
            activity?.finish()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
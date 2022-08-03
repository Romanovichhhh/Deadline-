package com.example.mvvmplayer.util.extensions

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment

fun NavController.safePopBackStack(): Boolean {
    return try {
        popBackStack()
    } catch (e: Exception) {
        false
    }
}

fun NavController.safeNavigate(@IdRes resId: Int) {
    runCatching { navigate(resId) }
}

fun NavController.safeNavigate(directions: NavDirections) {
    runCatching { navigate(directions) }
}

fun NavController.safeNavigate(
    @IdRes resId: Int,
    args: Bundle?,
    navOptions: NavOptions?
) {
    runCatching { navigate(resId, args, navOptions) }
}

fun FragmentActivity.findNavController(@IdRes viewId: Int) =
    (supportFragmentManager.findFragmentById(viewId) as? NavHostFragment)?.navController
        ?: Navigation.findNavController(this, viewId)

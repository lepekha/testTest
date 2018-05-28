package com.inhelp.view.mvp

import android.os.Bundle
import android.support.annotation.NonNull
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatDialogFragment


abstract class BaseRouter(private val fragmentManager: FragmentManager) {
    abstract fun showStartScreen()

    protected var currentStep: BaseMvpView? = null

    fun navigateTo(@NonNull fragment: Fragment, container: Int, addToBackStack: Boolean = true) {
        checkNotNull(fragmentManager)
        checkNotNull(fragment)
        val transaction = fragmentManager.beginTransaction()
//        transaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
//        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        transaction.replace(container, fragment)
        if (addToBackStack) {
            transaction.addToBackStack(fragment.tag)
        }
        transaction.commit()
    }


    fun clearBackStack() {
        val fragmentManager = fragmentManager
        while (fragmentManager.backStackEntryCount != 0) {
            fragmentManager.popBackStackImmediate()
        }
    }

    fun back() {
        if (fragmentManager.backStackEntryCount > 1) {
            fragmentManager.popBackStack()
        }
    }

}
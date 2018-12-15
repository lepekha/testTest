package com.inhelp.view.main

import androidx.annotation.NonNull
import androidx.fragment.app.FragmentManager
import com.inhelp.R
import com.inhelp.view.main.main.FragmentMain
import com.inhelp.view.main.main.WizzardMain
import com.inhelp.view.main.save.FragmentSave
import com.inhelp.view.main.save.WizzardSave
import com.inhelp.view.main.watchlist.WatchlistFragment
import com.inhelp.view.main.watchlist.WatchlistWizzard


class MainRouter: WatchlistWizzard, WizzardMain, WizzardSave {

    private val container: Int = R.id.container

    lateinit var fragmentManager: FragmentManager

    fun showStartScreen() {
        navigateTo(FragmentMain(), container)
    }

    fun goToRootWatchlist() {
//        clearBackStack()
        navigateTo(WatchlistFragment(), container)
    }

    override fun goToSave() {
        navigateTo(FragmentSave(), container)
    }

    fun navigateTo(@NonNull fragment: androidx.fragment.app.Fragment, container: Int, addToBackStack: Boolean = true) {
        val transaction = fragmentManager.beginTransaction()
//        transaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
        transaction.setTransition(androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
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

    override fun back() {
        if (fragmentManager.backStackEntryCount > 1) {
            fragmentManager.popBackStack()
        }
    }
}
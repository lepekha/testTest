package com.inhelp.view.main

import android.content.Context
import android.view.View
import androidx.annotation.NonNull
import androidx.core.view.ViewCompat
import androidx.fragment.app.FragmentManager
import androidx.transition.Fade
import androidx.transition.TransitionInflater
import androidx.transition.TransitionSet
import com.inhelp.R
import com.inhelp.view.main.main.FragmentMain
import com.inhelp.view.main.save.FragmentSave
import com.inhelp.view.main.reply.FragmentReply
import com.inhelp.view.main.watchlist.WatchlistFragment


class MainRouter(val context: Context) {

    private val container: Int = R.id.container

    private val MOVE_DEFAULT_TIME: Long = 300

    lateinit var fragmentManager: FragmentManager

    fun showStartScreen() {
        navigateTo(FragmentMain(), container)
    }

    fun goToRootWatchlist() {
        navigateTo(WatchlistFragment(), container)
    }

    fun goToSave() {
        navigateTo(FragmentSave(), container)
    }

    fun goToSave(view: View) {
        navigateTo(FragmentSave(), container, view = view)
    }

    fun goToRepost() {
        navigateTo(FragmentReply(), container)
    }

    fun goToRepost(view: View) {
        navigateTo(FragmentReply(), container, view = view)
    }

    fun navigateTo(@NonNull fragment: androidx.fragment.app.Fragment, container: Int, addToBackStack: Boolean = true, view: View? = null) {
        val transaction = fragmentManager.beginTransaction()

        view?.let {
            val enterTransitionSet = TransitionSet()
            enterTransitionSet.addTransition(TransitionInflater.from(context).inflateTransition(android.R.transition.move))
            enterTransitionSet.duration = MOVE_DEFAULT_TIME
            fragment.sharedElementEnterTransition = enterTransitionSet
            transaction.addSharedElement(it, ViewCompat.getTransitionName(it) ?: "sharedName")
        }

        transaction.setTransition(androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        transaction.replace(container, fragment)
        if (addToBackStack) {
            transaction.addToBackStack(fragment.tag)
        }
        transaction.commitAllowingStateLoss()
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
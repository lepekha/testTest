package com.inhelp.view.main

import androidx.annotation.NonNull
import androidx.fragment.app.FragmentManager
import com.inhelp.R
import com.inhelp.view.main.landimage.LandImageFragment
import com.inhelp.view.main.main.FragmentMain
import com.inhelp.view.main.reply.FragmentReply
import com.inhelp.view.main.save.FragmentSave
import com.inhelp.view.main.tags.FragmentTags

object RouteManager {

    private val container: Int = R.id.container
    lateinit var fragmentManager: FragmentManager

    fun goToMenu() {
        navigateTo(FragmentMain(), container)
    }

    fun goToLandImage() {
        navigateTo(LandImageFragment(), container)
    }

    fun goToSave() {
        navigateTo(FragmentSave(), container)
    }

    fun goToRepost() {
        navigateTo(FragmentReply(), container)
    }

    fun goToTags() {
        navigateTo(FragmentTags(), container)
    }

    fun navigateTo(@NonNull fragment: androidx.fragment.app.Fragment, container: Int, addToBackStack: Boolean = true) {
        val transaction = fragmentManager.beginTransaction()
        transaction.setCustomAnimations(R.anim.fragment_enter_from_right, R.anim.fragment_exit_to_left)
        transaction.replace(container, fragment)
        if (addToBackStack) {
            transaction.addToBackStack(fragment.tag)
        }
        transaction.commitAllowingStateLoss()
    }

    fun goToMain(){
        val transaction = fragmentManager.beginTransaction()
        transaction.setCustomAnimations(R.anim.fragment_enter_from_left, R.anim.fragment_exit_to_right)
        transaction.replace(container, FragmentMain())
        transaction.commitAllowingStateLoss()
    }


    fun clearBackStack() {
        val fragmentManager = fragmentManager
        while (fragmentManager.backStackEntryCount != 0) {
            fragmentManager.popBackStackImmediate()
        }
    }

    fun back(): Boolean {
        if (fragmentManager.backStackEntryCount > 1) {
            fragmentManager.popBackStack()
            return true
        } else {
            return false
        }
    }
}
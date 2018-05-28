package com.inhelp.view.main

import android.content.Context
import android.support.v4.app.FragmentManager
import com.inhelp.R
import com.inhelp.view.main.main.WizzardMain
import com.inhelp.view.main.save.WizzardSave
import com.inhelp.view.main.watchlist.WatchlistWizzard
import com.inhelp.view.mvp.BaseRouter
import javax.inject.Inject

class MainRouter @Inject constructor(fragmentManager: FragmentManager, val context: Context, private var fragmentHolder: MainFragmentHolder) :
        BaseRouter(fragmentManager = fragmentManager), WatchlistWizzard, WizzardMain, WizzardSave {

    private val container: Int = R.id.container

    override fun showStartScreen() {
        navigateTo(fragmentHolder.fragmentMain.get(), container)
    }


    fun goToRootWatchlist() {
//        clearBackStack()
//        navigateTo(fragmentHolder.watchlistFragment.get(), container)
    }

    override fun goToSave() {
        navigateTo(fragmentHolder.fragmentSave.get(), container)
    }
}
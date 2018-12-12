package com.inhelp.di.modules.main

import android.content.Context
import androidx.fragment.app.FragmentManager
import com.inhelp.core.models.UrlParseManager
import com.inhelp.di.scopes.ActivityScoped
import com.inhelp.view.main.MainActivity
import com.inhelp.view.main.MainFragmentHolder
import com.inhelp.view.main.MainPresenter
import com.inhelp.view.main.MainRouter
import com.inhelp.view.main.main.FragmentMain
import com.inhelp.view.main.main.PresenterMain
import com.inhelp.view.main.main.WizzardMain
import com.inhelp.view.main.save.FragmentSave
import com.inhelp.view.main.save.PresenterSave
import com.inhelp.view.main.save.WizzardSave
import com.inhelp.view.main.watchlist.WatchlistFragment
import com.inhelp.view.main.watchlist.WatchlistPresenter
import com.inhelp.view.main.watchlist.WatchlistWizzard
import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module
class MainProvideModule {

    @Provides
    @ActivityScoped
    fun provideMainPresenter(mainRouter: MainRouter): MainPresenter = MainPresenter(mainRouter)

    @Provides
    @ActivityScoped
    fun provideMainRouter(fragmentManager: androidx.fragment.app.FragmentManager, context: Context, mainFragmentHolder: MainFragmentHolder): MainRouter = MainRouter(fragmentManager, context, mainFragmentHolder)

    @Provides
    @ActivityScoped
    fun provideFragmentManager(activity: MainActivity): androidx.fragment.app.FragmentManager = activity.supportFragmentManager

    @Provides
    @ActivityScoped
    fun provideWatchlistPresenter(watchlistWizzard: WatchlistWizzard): WatchlistPresenter = WatchlistPresenter(watchlistWizzard)

    @Provides
    @ActivityScoped
    fun providePresenterMain(wizzardMain: WizzardMain): PresenterMain = PresenterMain(wizzardMain)

    @Provides
    @ActivityScoped
    fun providePresenterSave(wizzardSave: WizzardSave, context: Context): PresenterSave = PresenterSave(wizzardSave, context)

    @Provides
    @ActivityScoped
    fun provideMainFragmentHolder(
            watchlistFragment: Lazy<WatchlistFragment>,
            fragmentMain: Lazy<FragmentMain>,
            fragmentSave: Lazy<FragmentSave>):
            MainFragmentHolder = MainFragmentHolder(watchlistFragment, fragmentMain, fragmentSave)
}
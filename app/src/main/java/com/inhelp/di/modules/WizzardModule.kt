package com.inhelp.di.modules

import com.inhelp.view.main.MainRouter
import com.inhelp.view.main.main.WizzardMain
import com.inhelp.view.main.save.WizzardSave
import com.inhelp.view.main.watchlist.WatchlistWizzard
import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module
class WizzardModule {


    //Main

    @Provides
    fun provideWatchlistWizzard(smartMainRouter: Lazy<MainRouter>): WatchlistWizzard = smartMainRouter.get()

    @Provides
    fun provideWizzardMain(smartMainRouter: Lazy<MainRouter>): WizzardMain = smartMainRouter.get()

    @Provides
    fun provideWizzardSave(smartMainRouter: Lazy<MainRouter>): WizzardSave = smartMainRouter.get()



}
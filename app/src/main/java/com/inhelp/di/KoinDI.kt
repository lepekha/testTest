package com.inhelp.di

import com.inhelp.view.main.MainPresenter
import com.inhelp.view.main.MainRouter
import com.inhelp.view.main.main.PresenterMain
import com.inhelp.view.main.save.PresenterSave
import com.inhelp.view.main.watchlist.WatchlistPresenter
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

val appModule = module {

    single { MainRouter() }

    factory { MainPresenter(get()) }
    factory { PresenterMain(get()) }
    factory { WatchlistPresenter() }
    factory { PresenterSave(get(), androidContext()) }
}
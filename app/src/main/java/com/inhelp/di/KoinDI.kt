package com.inhelp.di

import com.inhelp.core.models.InstagramUrlData
import com.inhelp.utils.extension.clipboard
import com.inhelp.view.main.MainPresenter
import com.inhelp.view.main.MainRouter
import com.inhelp.view.main.main.PresenterMain
import com.inhelp.view.main.reply.PresenterReply
import com.inhelp.view.main.save.PresenterSave
import com.inhelp.view.main.tags.PresenterTags
import com.inhelp.view.main.watchlist.WatchlistPresenter
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

val appModule = module {

    single { MainRouter(androidContext()) }

    factory { MainPresenter(get()) }
    factory { PresenterMain(get()) }
    factory { WatchlistPresenter() }
    factory { PresenterSave(get(), get()) }
    factory { PresenterTags(get())}
    factory { PresenterReply(get(), androidContext()) }
    single { InstagramUrlData(androidContext()) }
}
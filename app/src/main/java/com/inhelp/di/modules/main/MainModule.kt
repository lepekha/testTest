package com.inhelp.di.modules.main

import com.inhelp.di.modules.WizzardModule
import com.inhelp.di.scopes.FragmentScoped
import com.inhelp.view.main.main.FragmentMain
import com.inhelp.view.main.save.FragmentSave
import com.inhelp.view.main.watchlist.WatchlistFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [(MainProvideModule::class), (WizzardModule::class)])
abstract class MainModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun provideWatchlistFragment(): WatchlistFragment

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun provideFragmentMain(): FragmentMain

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun provideFragmentSave(): FragmentSave


}
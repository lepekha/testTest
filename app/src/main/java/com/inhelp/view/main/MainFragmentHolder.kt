package com.inhelp.view.main

import com.inhelp.view.main.main.FragmentMain
import com.inhelp.view.main.save.FragmentSave
import com.inhelp.view.main.watchlist.WatchlistFragment
import dagger.Lazy
import javax.inject.Inject


data class MainFragmentHolder @Inject constructor(val watchlistFragment: Lazy<WatchlistFragment>, val fragmentMain: Lazy<FragmentMain>, val fragmentSave: Lazy<FragmentSave>)

package com.inhelp.view.main.watchlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.inhelp.R
import com.inhelp.view.mvp.BaseMvpFragment
import javax.inject.Inject

class WatchlistFragment @Inject constructor() : BaseMvpFragment<WatchlistView, WatchlistPresenter>(), WatchlistView {
    override fun backPress() {

    }


    @Inject
    override
    lateinit var presenter: WatchlistPresenter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.activity_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }




}
package com.inhelp.view.main.watchlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.inhelp.R
import com.inhelp.view.mvp.BaseMvpFragment
import org.koin.android.ext.android.inject


class WatchlistFragment : BaseMvpFragment<WatchlistView, WatchlistPresenter>(), WatchlistView {
    override fun backPress() {

    }


    override val presenter: WatchlistPresenter by inject()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_watchlist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }




}
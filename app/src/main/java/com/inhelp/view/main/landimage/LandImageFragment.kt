package com.inhelp.view.main.landimage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.inhelp.R
import com.inhelp.view.mvp.BaseMvpFragment
import org.koin.android.ext.android.inject


class LandImageFragment : BaseMvpFragment<LandImageView, LandImagePresenter>(), LandImageView {
    override fun backPress() {

    }


    override val presenter: LandImagePresenter by inject()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_watchlist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }




}
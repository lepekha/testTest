package com.inhelp.view.main.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.inhelp.R
import com.inhelp.view.mvp.BaseMvpFragment
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject

class FragmentMain @Inject constructor() : BaseMvpFragment<ViewMain, PresenterMain>(), ViewMain {
    override fun backPress() {
    }

    @Inject
    override
    lateinit var presenter: PresenterMain


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnSave.setOnClickListener {
            presenter.goToSave()
        }

    }




}
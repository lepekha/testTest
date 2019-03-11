package com.inhelp.view.main.main

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.inhelp.R
import com.inhelp.utils.extension.onTransitionEnd
import com.inhelp.view.mvp.BaseMvpFragment
import kotlinx.android.synthetic.main.fragment_main.*
import org.koin.android.ext.android.inject


class FragmentMain : BaseMvpFragment<ViewMain, PresenterMain>(), ViewMain {
    override fun backPress() {
    }

    override val presenter: PresenterMain by inject()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnSaveThis.setOnClickListener {
            presenter.pressSave(it)
        }

        btnMenuRepost.setOnClickListener{
            getCurrentActivity().setTheme(R.style.NewTheme)
            getCurrentActivity().recreate()
            presenter.pressRepost(it)
        }

        btnMenuTags.setOnClickListener {
            presenter.pressTags(it)
        }

        btnMenuSaveVideo.setOnClickListener {
            presenter.pressSaveVideo(it)
        }
    }
}
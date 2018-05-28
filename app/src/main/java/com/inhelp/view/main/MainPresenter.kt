package com.inhelp.view.main

import com.inhelp.view.mvp.BaseMvpPresenterImpl
import javax.inject.Inject


class MainPresenter @Inject constructor(private val router: MainRouter) : BaseMvpPresenterImpl<MainView>() {

    override fun attachView(view: MainView) {
        super.attachView(view)
        router.showStartScreen()
    }

    fun backPress() {
        router.back()
    }

    fun pressWatchlist() {
        router.goToRootWatchlist()
    }

}
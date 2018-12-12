package com.inhelp.view.main

import androidx.fragment.app.Fragment
import com.inhelp.view.mvp.BaseMvpPresenterImpl
import javax.inject.Inject


class MainPresenter @Inject constructor(private val router: MainRouter) : BaseMvpPresenterImpl<MainView>() {

    private var mCurrentFragment: androidx.fragment.app.Fragment? = null

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

    override fun detachView() {
        super.detachView()
    }

    fun openFragment(intExtra: Int) {
        when(intExtra){
//            0 -> router.showStartScreen()
            1 -> router.goToSave()
        }
    }
}
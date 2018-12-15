package com.inhelp.view.main

import com.inhelp.view.mvp.BaseMvpPresenterImpl


class MainPresenter constructor(val router: MainRouter) : BaseMvpPresenterImpl<MainView>() {

    private var mCurrentFragment: androidx.fragment.app.Fragment? = null

    override fun attachView(view: MainView) {
        super.attachView(view)
        router.fragmentManager = (view.getCurrentActivity() as MainActivity).supportFragmentManager
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
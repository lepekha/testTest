package com.inhelp.view.main

import com.inhelp.view.mvp.BaseMvpPresenterImpl


class MainPresenter constructor(val router: MainRouter) : BaseMvpPresenterImpl<MainView>() {

    private var mCurrentFragment: androidx.fragment.app.Fragment? = null

    override fun attachView(view: MainView) {
        super.attachView(view)
        router.fragmentManager = (view.getCurrentActivity() as MainActivity).supportFragmentManager
    }

    fun showStartScreen(){
        router.goToMenu()
    }

    fun backPress() {
        if(!router.back()){
            view?.finishApplication()
        }
    }

    fun pressWatchlist() {
        router.goToLandImage()
    }

    override fun detachView() {
        super.detachView()
    }

    fun openFragment(intExtra: Int) {
        when(intExtra){
//            0 -> router.goToMenu()
            1 -> router.goToSave()
        }
    }
}
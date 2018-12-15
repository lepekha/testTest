package com.inhelp.view.main.main

import com.inhelp.view.main.MainRouter
import com.inhelp.view.mvp.BaseMvpPresenterImpl



class PresenterMain constructor(val mainRouter: MainRouter) : BaseMvpPresenterImpl<ViewMain>() {
    fun goToSave() {
        mainRouter.goToSave()
    }

    fun goToWatchlist(){
        mainRouter.goToRootWatchlist()
    }
}
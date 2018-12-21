package com.inhelp.view.main.main

import android.view.View
import com.inhelp.view.main.MainRouter
import com.inhelp.view.mvp.BaseMvpPresenterImpl



class PresenterMain constructor(val mainRouter: MainRouter) : BaseMvpPresenterImpl<ViewMain>() {
    fun pressSave(view: View) {
        mainRouter.goToSave(view)
    }

    fun pressRepost(view: View) {
        mainRouter.goToRepost(view)
    }

    fun goToWatchlist(){
        mainRouter.goToRootWatchlist()
    }
}
package com.inhelp.view.mvp


interface BaseMvpPresenter <in V : BaseMvpView> {

    fun onBackPress()

    fun attachView(view: V)

    fun detachView()

}
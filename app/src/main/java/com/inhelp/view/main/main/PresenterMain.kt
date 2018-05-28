package com.inhelp.view.main.main

import com.inhelp.view.mvp.BaseMvpPresenterImpl
import javax.inject.Inject


class PresenterMain @Inject constructor(private val wizzardMain: WizzardMain) : BaseMvpPresenterImpl<ViewMain>() {
    fun goToSave() {
        wizzardMain.goToSave()
    }


}
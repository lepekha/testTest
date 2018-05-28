package com.inhelp.view.mvp

import android.content.Context
import android.support.annotation.StringRes
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.Toolbar

interface BaseMvpView {

    fun getCurrentContext(): Context

    fun getCurrentActivity(): FragmentActivity

    fun showError(error: String?)

    fun showError(@StringRes stringResId: Int)

    fun showAlert(@StringRes srtResId: Int)

    fun showAlert(message: String)


    fun backPress()
}
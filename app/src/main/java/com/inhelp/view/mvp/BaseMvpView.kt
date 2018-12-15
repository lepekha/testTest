package com.inhelp.view.mvp

import android.content.Context
import androidx.annotation.StringRes

interface BaseMvpView {

    fun getCurrentContext(): Context

    fun getCurrentActivity(): androidx.fragment.app.FragmentActivity

    fun showError(error: String?)

    fun showError(@StringRes stringResId: Int)

    fun showAlert(@StringRes srtResId: Int)

    fun showAlert(message: String)


    fun backPress()
}
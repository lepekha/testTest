package com.inhelp.view.main.reply

import android.graphics.Bitmap
import com.inhelp.view.mvp.BaseMvpView

interface ViewReply : BaseMvpView {
    fun setImage(image: Bitmap)
    fun showError()
}
package com.inhelp.view.main.save

import android.graphics.Bitmap
import com.inhelp.view.mvp.BaseMvpView

interface ViewSave : BaseMvpView {
    fun setPhoto(url: String)
    fun showError()
    fun getImageChache(): Bitmap
}
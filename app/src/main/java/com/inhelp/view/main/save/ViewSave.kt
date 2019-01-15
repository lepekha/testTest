package com.inhelp.view.main.save

import android.graphics.Bitmap
import com.inhelp.view.mvp.BaseMvpView

interface ViewSave : BaseMvpView {
    fun setPhoto(imageUrl: String, isFewPhoto: Boolean)
    fun showError()
    fun share(bit: Bitmap)
    fun setPreviewPhotos(items: ArrayList<String>)
}
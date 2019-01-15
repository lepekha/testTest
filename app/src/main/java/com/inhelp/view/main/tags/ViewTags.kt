package com.inhelp.view.main.tags

import android.graphics.Bitmap
import com.inhelp.view.mvp.BaseMvpView

interface ViewTags : BaseMvpView {
    fun setFilterList(tagsFilter: MutableList<Tags>)
    fun setVisiblePlaceholder(isVisible: Boolean)
}
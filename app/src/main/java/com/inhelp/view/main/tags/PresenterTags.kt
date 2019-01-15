package com.inhelp.view.main.tags

import android.Manifest
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.view.View
import com.inhelp.core.models.InstagramUrlData
import com.inhelp.utils.Utils
import com.inhelp.utils.extension.saveToSD
import com.inhelp.utils.extension.toast
import com.inhelp.view.main.MainRouter
import com.inhelp.view.mvp.BaseMvpPresenterImpl
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import kotlinx.coroutines.*


class PresenterTags constructor(private val mainRouter: MainRouter) : BaseMvpPresenterImpl<ViewTags>() {

    var tagsList = arrayListOf<Tags>()
    var tagsTitle = arrayOf<String>()
    var tagsText = arrayOf<String>()

    override fun onBackPress() {
        mainRouter.back()
    }

    fun pressBack(view: View){
        mainRouter.goToMenu(view)
    }

    fun initList(){
        (0 until tagsTitle.size).forEach { index ->
            tagsList.add(Tags(tagsTitle[index], tagsText[index]))
        }
    }

    fun changeFilter(text: String) {
        val filterTags = tagsList.filter { tag -> tag.text.contains(text, ignoreCase = true) }.toMutableList()
        view?.setFilterList(filterTags)
        view?.setVisiblePlaceholder(filterTags.isEmpty())
    }
}
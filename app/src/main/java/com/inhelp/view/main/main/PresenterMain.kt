package com.inhelp.view.main.main

import android.os.Build
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import com.inhelp.view.main.MainRouter
import com.inhelp.view.mvp.BaseMvpPresenterImpl
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlin.random.Random
import kotlin.system.measureTimeMillis


class PresenterMain constructor(val mainRouter: MainRouter) : BaseMvpPresenterImpl<ViewMain>() {
    fun pressSave(view: View) {
        mainRouter.goToSave(view)
    }

    fun pressRepost(view: View) = runBlocking  {
//        mainRouter.goToRepost(view)




    }




    fun pressTags(view: View) {
        mainRouter.goToTags(view)
    }

    fun pressSaveVideo(view: View){
        mainRouter.goToLandImage()
    }
}


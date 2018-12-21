package com.inhelp.view.main.reply

import android.Manifest
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import com.inhelp.core.models.services.ServiceSavePhoto
import com.inhelp.utils.PhotoUtils
import com.inhelp.utils.extension.getClipboard
import com.inhelp.utils.extension.saveBitmap
import com.inhelp.view.customView.reply.RectangleReplyStyleImpl
import com.inhelp.view.main.MainRouter
import com.inhelp.view.mvp.BaseMvpPresenterImpl
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import kotlinx.coroutines.*


class PresenterReply constructor(private val mainRouter: MainRouter, private val context: Context) : BaseMvpPresenterImpl<ViewReply>() {

    private lateinit var mIntentSaveService: Intent
    private lateinit var mLoadedBitmap: Bitmap

    override fun attachView(view: ViewReply) {
        super.attachView(view)
        mIntentSaveService = Intent(context, ServiceSavePhoto::class.java)
        context.startService(mIntentSaveService)
    }

    override fun detachView() {
        super.detachView()
        context.stopService(mIntentSaveService)
    }

    fun onViewCreated() {
        getPhoto()
    }

    override fun onBackPress() {
        mainRouter.back()
    }


    fun getPhoto() = GlobalScope.launch(Dispatchers.Main) {
//        val image = UrlParseManager.getPhoto(context.getClipboard())
//        val iii = RectangleReplyStyleImpl.build { title = "ruslan.lepekha" }
//        mLoadedBitmap = iii.generateImage(image.await())
//        view?.setImage(iii.generateImage(mLoadedBitmap))
    }

    private fun savePhoto(){
        val millis = System.currentTimeMillis()
        val seconds = millis / 1000

//        view?.getImageChache()?.let {
//            val res = PhotoUtils.saveCurrentPhoto(context, it, "photo_$seconds")
//            if(res.isNotEmpty()){
//                onBackPress()
//            }
//        }


    }
    fun pressRepost(){
//        view?.repost(context.saveBitmap(mLoadedBitmap))
    }

    fun getPermissionAndSavePhoto(){
        Dexter.withActivity(view?.getCurrentActivity())
                .withPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .withListener(object : PermissionListener {
                    override fun onPermissionGranted(response: PermissionGrantedResponse?) {
                        savePhoto()
                    }

                    override fun onPermissionRationaleShouldBeShown(permission: PermissionRequest?, token: PermissionToken?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onPermissionDenied(response: PermissionDeniedResponse?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }
                }).check()
    }


}
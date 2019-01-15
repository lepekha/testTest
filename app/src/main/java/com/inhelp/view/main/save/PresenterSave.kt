package com.inhelp.view.main.save

import android.Manifest
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
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


class PresenterSave constructor(private val mainRouter: MainRouter, private val instagramUrlData: InstagramUrlData) : BaseMvpPresenterImpl<ViewSave>() {

    private lateinit var mIntentSaveService: Intent
    private lateinit var mLoadedBitmap: Bitmap

    private lateinit var mPreviewPhotos: ArrayList<String>
    private var mCurrentPhotoNumber: Int = 0

    fun onResume(){
        if(instagramUrlData.isValidUrl) {
            getPhoto()
        }else{
            view?.showError()
        }
//        mIntentSaveService = Intent(context, ServiceSavePhoto::class.java)
//        context.startService(mIntentSaveService)
    }

    override fun detachView() {
        super.detachView()
//        context.stopService(mIntentSaveService)
    }

    override fun onBackPress() {
        mainRouter.back()
    }

    fun pressPreviewItem(previewPosition: Int) {
        mCurrentPhotoNumber = previewPosition
        view?.setPhoto(mPreviewPhotos[previewPosition], isFewPhoto = true)
    }

    fun pressSaveThis() = runBlocking {
        val bmpToSave = Utils.loadImage(mPreviewPhotos[mCurrentPhotoNumber]).await()
        bmpToSave.saveToSD()
        view?.getCurrentActivity()?.toast("Photo was saved")
    }

    fun pressSaveAll() = runBlocking {
        mPreviewPhotos.forEach {
            val bmpToSave = Utils.loadImage(it).await()
            bmpToSave.saveToSD()
        }
        view?.getCurrentActivity()?.toast("All photos was saved")
    }

    private fun getPhoto() = GlobalScope.launch(Dispatchers.Main) {
        mPreviewPhotos = instagramUrlData.getPhotos().await()
        val isFewPhoto = mPreviewPhotos.count() > 1
        if (isFewPhoto) view?.setPreviewPhotos(mPreviewPhotos)
        view?.setPhoto(mPreviewPhotos.first(), isFewPhoto = isFewPhoto)
    }

    fun getPermissionAndSavePhoto() {
        Dexter.withActivity(view?.getCurrentActivity())
                .withPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .withListener(object : PermissionListener {
                    override fun onPermissionGranted(response: PermissionGrantedResponse?) {
//                        context.saveBitmap(mLoadedBitmap)
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
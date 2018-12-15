package com.inhelp.view.main.save

import android.Manifest
import android.content.Context
import android.content.Intent
import com.inhelp.core.models.UrlParseManager
import com.inhelp.core.models.services.ServiceSavePhoto
import com.inhelp.utils.PhotoUtils
import com.inhelp.utils.extension.getClipboard
import com.inhelp.view.main.MainRouter
import com.inhelp.view.mvp.BaseMvpPresenterImpl
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class PresenterSave constructor(private val mainRouter: MainRouter, private val context: Context) : BaseMvpPresenterImpl<ViewSave>() {

    private lateinit var mIntentSaveService: Intent

    override fun attachView(view: ViewSave) {
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


    fun getPhoto(){
        UrlParseManager.getPhoto(context.getClipboard())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { it ->
                    if(!it.isNullOrEmpty()){
                        view?.setPhoto(it)
                    }else{
                        view?.showError()
                    }
                }
    }

    private fun savePhoto(){
        val millis = System.currentTimeMillis()
        val seconds = millis / 1000

        view?.getImageChache()?.let {
            val res = PhotoUtils.saveCurrentPhoto(context, it, "photo_$seconds")
            if(res.isNotEmpty()){
                onBackPress()
            }
        }


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
package com.inhelp.view.main.save

import android.Manifest
import android.app.Activity
import android.content.ClipboardManager
import android.content.Context
import com.inhelp.core.models.UrlParseManager
import com.inhelp.view.mvp.BaseMvpPresenterImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import android.content.Context.CLIPBOARD_SERVICE
import com.inhelp.utils.PhotoUtils
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener


class PresenterSave @Inject constructor(private val wizzardSave: WizzardSave, private val urlParseManager: UrlParseManager, private val context: Context) : BaseMvpPresenterImpl<ViewSave>() {

    private var mClipboard: String = ""

    fun onViewCreated() {
        getPhoto()
    }

    override fun onBackPress() {
        wizzardSave.back()
    }

    private fun getClipBoardText(){
        val clipboard = context.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
        mClipboard = clipboard.primaryClip.getItemAt(0).text.toString()
    }

    fun getPhoto(){
        getClipBoardText()
        urlParseManager.getPhoto(mClipboard)
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
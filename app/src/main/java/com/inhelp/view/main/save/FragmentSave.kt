package com.inhelp.view.main.save

import android.app.Activity
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.inhelp.R
import com.inhelp.view.main.MainActivity
import com.inhelp.view.mvp.BaseMvpFragment
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_save.*
import java.lang.Exception
import javax.inject.Inject

class FragmentSave @Inject constructor() : BaseMvpFragment<ViewSave, PresenterSave>(), ViewSave {
    override fun backPress() {
    }

    @Inject
    override
    lateinit var presenter: PresenterSave


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_save, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onViewCreated()
        imgPhoto.isDrawingCacheEnabled = true
        btnAdd.setOnClickListener {
            presenter.getPhoto()
            groupError.visibility = View.GONE
            pgLoad.visibility = View.VISIBLE
        }
        btnBack.setOnClickListener {
            presenter.onBackPress()
        }
        btnSave.setOnClickListener {
            presenter.getPermissionAndSavePhoto()
        }
    }

    override fun getImageChache() = imgPhoto.drawingCache


    override fun setPhoto(url: String){
        Picasso.get().load(url).into(imgPhoto, object: Callback{
            override fun onSuccess() {
                pgLoad.visibility = View.GONE
                imgPhoto.visibility = View.VISIBLE
                btnSave.visibility = View.VISIBLE
            }

            override fun onError(e: Exception?) {}
        })
    }


    override fun showError(){
        pgLoad.visibility = View.GONE
        groupError.visibility = View.VISIBLE
    }




}
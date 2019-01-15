package com.inhelp.view.main.save

import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.inhelp.R
import com.inhelp.utils.extension.launchApp
import com.inhelp.view.mvp.BaseMvpFragment
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_save.*
import org.koin.android.ext.android.inject
import java.lang.Exception


class FragmentSave: BaseMvpFragment<ViewSave, PresenterSave>(), ViewSave {
    override fun backPress() {
    }


    override val presenter: PresenterSave by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_save, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnAdd.setOnClickListener {
            getCurrentContext().launchApp("com.instagram.android")
        }
        titleSave.setOnClickListener {
            presenter.onBackPress()
        }
        btnSaveThis.setOnClickListener {
            presenter.pressSaveThis()
        }

        btnSaveAll.setOnClickListener {
            presenter.pressSaveAll()
        }

        lstPreview.layoutManager = LinearLayoutManager(getCurrentContext(), RecyclerView.HORIZONTAL, false)
        lstPreview.setHasFixedSize(true)
    }

    override fun share(bit: Bitmap) {

    }

    override fun setPreviewPhotos(items: ArrayList<String>){
        lstPreview.adapter = PreviewRvAdapter(items, getCurrentContext()){
            presenter.pressPreviewItem(it)
        }
    }

    override fun setPhoto(imageUrl: String, isFewPhoto: Boolean) {
        Picasso.get().load(imageUrl).into(imgPhoto, object : Callback {
            override fun onSuccess() {
                pgLoad.isVisible = false
                imgPhoto.isVisible = true
                btnSaveThis.isVisible = true
                groupPreview.isVisible = isFewPhoto
            }

            override fun onError(e: Exception?) {}
        })
    }


    override fun showError() {
        pgLoad.isVisible = false
        groupError.isVisible = true
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }
}
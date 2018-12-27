package com.inhelp.view.main.save

import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.inhelp.R
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
            presenter.getPhoto()
            groupError.visibility = View.GONE
            pgLoad.visibility = View.VISIBLE
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

        lstPreview.layoutManager = LinearLayoutManager(getCurrentContext(), LinearLayoutManager.HORIZONTAL, false)
    }

    override fun share(bit: Bitmap) {

    }

    override fun setPreviewPhotos(items: ArrayList<String>){
        lstPreview.adapter = PreviewRvAdapter(items, getCurrentContext()){
            presenter.pressPreviewItem(it)
        }

        btnSaveAll.visibility = View.VISIBLE
    }

    override fun setPhoto(imageUrl: String) {
        Picasso.get().load(imageUrl).into(imgPhoto, object : Callback {
            override fun onSuccess() {
                pgLoad.visibility = View.GONE
                imgPhoto.visibility = View.VISIBLE
                btnSaveThis.visibility = View.VISIBLE
            }

            override fun onError(e: Exception?) {}
        })
//        imgPhoto.setImageBitmap(image)

    }


    override fun showError() {
        pgLoad.visibility = View.GONE
        groupError.visibility = View.VISIBLE
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }
}
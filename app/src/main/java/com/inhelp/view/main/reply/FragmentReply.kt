package com.inhelp.view.main.reply

import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.inhelp.R
import com.inhelp.view.mvp.BaseMvpFragment
import org.koin.android.ext.android.inject
import kotlinx.android.synthetic.main.fragment_reply.*


class FragmentReply : BaseMvpFragment<ViewReply, PresenterReply>(), ViewReply {
    override fun backPress() {
    }


    override val presenter: PresenterReply by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_reply, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onViewCreated()

        btnAdd.setOnClickListener {
            presenter.getPhoto()
            groupError.visibility = View.GONE
            pgLoad.visibility = View.VISIBLE
        }
        txtTitle.setOnClickListener {
            presenter.onBackPress()
        }
        btnRepostPhoto.setOnClickListener {
            presenter.pressRepost()
        }
    }



    override fun setImage(image: Bitmap) {
        imgPhoto.setImageBitmap(image)
        pgLoad.visibility = View.GONE
        imgPhoto.visibility = View.VISIBLE
        btnRepostPhoto.visibility = View.VISIBLE
    }


    override fun showError() {
        pgLoad.visibility = View.GONE
        groupError.visibility = View.VISIBLE
    }


}
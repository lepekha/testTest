package com.inhelp.view.main.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintSet
import androidx.transition.AutoTransition
import androidx.transition.TransitionManager
import com.inhelp.R
import com.inhelp.view.mvp.BaseMvpFragment
import kotlinx.android.synthetic.main.fragment_main.*
import org.koin.android.ext.android.inject


class FragmentMain : BaseMvpFragment<ViewMain, PresenterMain>(), ViewMain {
    override fun backPress() {
    }

    override val presenter: PresenterMain by inject()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        btnSave.post { showComponents() }



        btnSaveThis.setOnClickListener {
            presenter.pressSave(it)
        }

        btnMenuRepost.setOnClickListener{
            presenter.pressRepost(it)
        }


    }


    private fun showComponents(){
        val constraintSet = ConstraintSet()
        constraintSet.clone(getCurrentContext(), R.layout.fragment_main_end)

        val autoTransition = AutoTransition()
        autoTransition.duration = 700
        TransitionManager.beginDelayedTransition(container, autoTransition)
        constraintSet.applyTo(container)
    }


}
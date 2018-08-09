package com.inhelp.view.main.main

import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.support.transition.AutoTransition
import android.support.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.inhelp.R
import com.inhelp.view.mvp.BaseMvpFragment
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject

class FragmentMain @Inject constructor() : BaseMvpFragment<ViewMain, PresenterMain>(), ViewMain {
    override fun backPress() {
    }

    @Inject
    override
    lateinit var presenter: PresenterMain


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main_end, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        btnSave.post { showComponents() }

        imageView1.setOnClickListener {

//            presenter.goToSave()
        }

        btnSave.setOnClickListener{
            presenter.goToSave()
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
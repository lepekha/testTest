package com.inhelp.view.mvp

import android.content.Context
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.widget.Toast
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseMvpActivity<in V : BaseMvpView, out T : BaseMvpPresenter<V>> : DaggerAppCompatActivity(), BaseMvpView {

    protected abstract val presenter: T



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.attachView(view = this as V)
    }

    override fun getCurrentContext(): Context = this

    override fun showError(error: String?) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    override fun showError(stringResId: Int) {
        Toast.makeText(this, stringResId, Toast.LENGTH_LONG).show()
    }


    override fun showAlert(srtResId: Int) {
        //TODO alert
    }

    override fun showAlert(message: String) {
        //TODO alert
    }


    override fun getCurrentActivity(): FragmentActivity {
        return this
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}
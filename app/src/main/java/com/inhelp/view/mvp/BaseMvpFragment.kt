package com.inhelp.view.mvp

import android.content.Context
import android.os.Bundle

abstract class BaseMvpFragment<in V : BaseMvpView, out T : BaseMvpPresenter<V>> : androidx.fragment.app.DialogFragment(), BaseMvpView {

    protected abstract val presenter: T
    private var view: BaseMvpActivity<BaseMvpView, BaseMvpPresenterImpl<BaseMvpView>>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.attachView(view = this as V)
    }

    override fun showError(error: String?) {
        (activity as BaseMvpActivity<*, *>).showError(error)
    }

    override fun showError(stringResId: Int) {
        (activity as BaseMvpActivity<*, *>).showError(stringResId)
    }

    override fun showAlert(srtResId: Int) {
        (activity as BaseMvpActivity<*, *>).showAlert(srtResId)
    }

    override fun showAlert(message: String) {
        (activity as BaseMvpActivity<*, *>).showAlert(message)
    }

    override fun getCurrentContext(): Context {
        return (activity as BaseMvpActivity<*, *>).getCurrentContext()
    }


    override fun getCurrentActivity(): androidx.fragment.app.FragmentActivity {
        return (activity as BaseMvpActivity<*, *>).getCurrentActivity()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

}
package com.inhelp.view.mainimport android.content.pm.ActivityInfoimport android.os.Bundleimport com.inhelp.Rimport com.inhelp.view.mvp.BaseMvpActivityimport org.koin.android.ext.android.injectclass MainActivity : BaseMvpActivity<MainView, MainPresenter>(), MainView {    override val presenter: MainPresenter by inject()    override fun onCreate(savedInstanceState: Bundle?) {        super.onCreate(savedInstanceState)        setContentView(R.layout.activity_main)        presenter.showStartScreen()    }    override fun backPress() {        presenter.backPress()    }    override fun onBackPressed() {        backPress()    }    override fun onResume() {        super.onResume()    }    override fun finishApplication() {        finish()    }}
package com.inhelpimport android.app.Applicationimport com.inhelp.di.appModuleimport org.koin.android.ext.android.startKoinclass MainApp : Application() {    override fun onCreate() {        super.onCreate()        startKoin(this, listOf(appModule))    }}
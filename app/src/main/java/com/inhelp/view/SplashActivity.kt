package com.inhelp.viewimport android.app.Activityimport android.content.Intentimport android.content.pm.ActivityInfoimport android.os.Bundleimport androidx.appcompat.app.AppCompatActivityimport com.inhelp.view.main.MainActivityclass SplashActivity : AppCompatActivity() {    override fun onCreate(savedInstanceState: Bundle?) {        super.onCreate(savedInstanceState)            val intent = Intent(this, MainActivity::class.java)            startActivity(intent)            finish()    }}
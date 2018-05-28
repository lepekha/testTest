package com.inhelp.di.modules

import com.inhelp.di.modules.main.MainModule
import com.inhelp.di.scopes.ActivityScoped
import com.inhelp.view.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [(MainModule::class)])
    abstract fun mainActivity(): MainActivity

}
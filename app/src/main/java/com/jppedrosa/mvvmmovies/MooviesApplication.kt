package com.jppedrosa.mvvmmovies

import android.app.Activity
import android.app.Application
import android.content.Context
import com.jppedrosa.mvvmmovies.di.AppInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * @author João Pedro Pedrosa ([joaopopedrosa@gmail.com](mailto:joaopopedrosa@gmail.com)) on 22/08/2022.
 */
class MooviesApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    init {
        instance = this
    }

    companion object {
        private var instance: MooviesApplication? = null
        fun applicationContext(): Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this)
    }

    override fun activityInjector() = dispatchingAndroidInjector
}
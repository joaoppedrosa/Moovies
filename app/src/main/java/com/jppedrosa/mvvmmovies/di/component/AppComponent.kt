package com.jppedrosa.mvvmmovies.di.component

import android.app.Application
import com.jppedrosa.mvvmmovies.MooviesApplication
import com.jppedrosa.mvvmmovies.di.module.ActivityBuilderModule
import com.jppedrosa.mvvmmovies.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * @author João Pedro Pedrosa (<a href="mailto:joaopopedrosa@gmail.com">joaopopedrosa@gmail.com</a>) on 22/08/2022.
 */
@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityBuilderModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(application: MooviesApplication)
}
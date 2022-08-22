package com.jppedrosa.mvvmmovies.di.module

import com.jppedrosa.mvvmmovies.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author João Pedro Pedrosa (<a href="mailto:joaopopedrosa@gmail.com">joaopopedrosa@gmail.com</a>) on 22/08/2022.
 */

@Module(includes = [FragmentBuilderModule::class])
interface ActivityBuilderModule {

    @ContributesAndroidInjector
    fun contributeMainActivity(): MainActivity
}
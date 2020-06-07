package com.company.app.ui.activities.main.di

import com.company.app.appbase.injection.scope.PerActivity
import com.company.app.ui.activities.main.MainActivity
import dagger.Subcomponent

@PerActivity
@Subcomponent(modules = [MainActivityModule::class])
interface MainActivityComponent {

    fun inject(activity: MainActivity)
}
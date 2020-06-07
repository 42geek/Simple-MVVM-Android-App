package com.company.app.ui.activities.main.di

import com.company.app.appbase.ApplicationStarter
import com.company.app.appbase.injection.scope.PerActivity
import com.company.app.ui.activities.main.MainActivityViewModel
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    @PerActivity
    fun provideViewModel(applicationStarter: ApplicationStarter): MainActivityViewModel = MainActivityViewModel(applicationStarter)
}
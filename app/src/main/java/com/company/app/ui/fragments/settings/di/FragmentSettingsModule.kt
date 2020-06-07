package com.company.app.ui.fragments.settings.di

import com.company.app.appbase.ApplicationStarter
import com.company.app.appbase.injection.scope.PerFragment
import com.company.app.data.repository.Repository
import com.company.app.ui.fragments.settings.FragmentSettingsViewModel
import dagger.Module
import dagger.Provides

@Module
class FragmentSettingsModule {

    @Provides
    @PerFragment
    fun provideViewModel(applicationStarter: ApplicationStarter, repository: Repository): FragmentSettingsViewModel =
        FragmentSettingsViewModel(
            applicationStarter,
            repository
        )

}
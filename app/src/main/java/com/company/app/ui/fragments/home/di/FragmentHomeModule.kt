package com.company.app.ui.fragments.home.di

import com.company.app.appbase.ApplicationStarter
import com.company.app.appbase.injection.scope.PerFragment
import com.company.app.data.repository.Repository
import com.company.app.ui.fragments.home.FragmentHomeViewModel
import dagger.Module
import dagger.Provides

@Module
class FragmentHomeModule {

    @Provides
    @PerFragment
    fun provideViewModel(applicationStarter: ApplicationStarter, repository: Repository): FragmentHomeViewModel =
        FragmentHomeViewModel(
            applicationStarter,
            repository
        )

}
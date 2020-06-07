package com.company.app.ui.activities.onboarding.di

import com.company.app.appbase.ApplicationStarter
import com.company.app.appbase.injection.scope.PerActivity
import com.company.app.ui.activities.onboarding.OnboardingViewModel
import dagger.Module
import dagger.Provides

@Module
class OnboardingModule {

    @Provides
    @PerActivity
    fun provideViewModel(applicationStarter: ApplicationStarter): OnboardingViewModel = OnboardingViewModel(applicationStarter)

}
package com.company.app.ui.fragments.settings

import androidx.lifecycle.AndroidViewModel
import com.company.app.appbase.ApplicationStarter
import com.company.app.data.repository.Repository
import javax.inject.Inject

class FragmentSettingsViewModel @Inject constructor(applicationStarter: ApplicationStarter,
                                                    private val repository: Repository): AndroidViewModel(applicationStarter) {




}
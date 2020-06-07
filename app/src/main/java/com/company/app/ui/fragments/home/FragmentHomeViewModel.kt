package com.company.app.ui.fragments.home

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.company.app.appbase.ApplicationStarter
import com.company.app.data.apis.github.model.GithubRepo
import com.company.app.data.repository.Repository
import javax.inject.Inject

/**
 * AndroidViewModel has application context.
 */
class FragmentHomeViewModel @Inject constructor(applicationStarter: ApplicationStarter,
                                                private val repository: Repository): AndroidViewModel(applicationStarter) {


    fun getGitDataFromRepository(since: Int): LiveData<List<GithubRepo>?> {
        return repository.getGithubReposList(since)
    }

}
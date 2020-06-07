package com.company.app.data.apis.github

import com.company.app.data.apis.github.model.GithubRepo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * GitHub Retrofit Service
 */
interface GithubApiService {

    private companion object {

        //Lists all public repositories in the order that they were created.
        const val REPOS_ENDPOINT = "repositories"

        //The integer ID of the last repository that you've seen.
        const val PARAM_SINCE = "since"
    }

    @GET(REPOS_ENDPOINT)
    fun getListOfRepos(@Query(PARAM_SINCE) since: Int): Call<List<GithubRepo>>

}
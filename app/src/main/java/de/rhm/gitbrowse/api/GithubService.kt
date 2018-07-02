package de.rhm.gitbrowse.api

import de.rhm.gitbrowse.api.model.SearchRepositoriesResponse
import io.reactivex.Single
import retrofit2.http.GET

interface GithubService {
    @GET("search/repositories?q=topic:android&sort=stars&order=desc")
    fun getTrendingAndroidRepositories(): Single<SearchRepositoriesResponse>
}
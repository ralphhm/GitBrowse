package de.rhm.gitbrowse.api

import de.rhm.gitbrowse.api.model.SearchRepositoriesResponse
import de.rhm.gitbrowse.api.model.User
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {
    @GET("search/repositories?q=topic:android&sort=stars&order=desc")
    fun getTrendingAndroidRepositories(): Single<SearchRepositoriesResponse>

    @GET("repos/{full_name}/subscribers")
    fun getSubscribers(@Path("full_name", encoded = true) repositoryName: String): Single<List<User>>
}
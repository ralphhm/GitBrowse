package de.rhm.gitbrowse

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import de.rhm.gitbrowse.api.GithubService
import de.rhm.gitbrowse.api.model.Repository

class BrowseViewModel(private val service: GithubService) : ViewModel() {

    private val result = MutableLiveData<List<Repository>>()
    val repositories: LiveData<List<Repository>> get() = result

    init {
        Thread {
            result.postValue(service.getTrendingAndroidRepositories().execute().body()?.repositories
                    ?: emptyList())
        }.start()
    }

}
package de.rhm.gitbrowse

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import de.rhm.gitbrowse.api.GithubService

class BrowseViewModel(private val service: GithubService) : ViewModel() {

    private val result = MutableLiveData<BrowseUiState>()
    val repositories: LiveData<BrowseUiState> get() = result

    init {
        Thread {
            result.postValue(BrowseUiState.Loading)
            try {
                val response = service.getTrendingAndroidRepositories().execute()
                when (response.isSuccessful) {
                    true -> BrowseUiState.Success(response.body()!!.repositories)
                    false -> BrowseUiState.Failure(response.message())
                }.let { result.postValue(it) }
            } catch (e: Exception) {
                result.postValue(BrowseUiState.Failure(e.message))
            }

        }.start()
    }

}
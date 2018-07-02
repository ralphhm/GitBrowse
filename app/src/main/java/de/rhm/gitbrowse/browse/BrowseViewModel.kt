package de.rhm.gitbrowse.browse

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import de.rhm.gitbrowse.api.GithubService

class BrowseViewModel(service: GithubService) : ViewModel() {

    val uiState = MutableLiveData<BrowseUiState>()

    init {
        service.getTrendingAndroidRepositories().toObservable()
                .map<BrowseUiState> { BrowseUiState.Success(it.repositories) }
                .startWith(BrowseUiState.Loading)
                .onErrorReturn { BrowseUiState.Failure(it.localizedMessage) }
                .subscribe { uiState.postValue(it) }
    }

}
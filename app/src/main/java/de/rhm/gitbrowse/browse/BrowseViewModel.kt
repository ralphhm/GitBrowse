package de.rhm.gitbrowse.browse

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import de.rhm.gitbrowse.api.GithubService
import io.reactivex.subjects.PublishSubject

class BrowseViewModel(service: GithubService) : ViewModel() {

    val uiState = MutableLiveData<BrowseUiState>()
    private val action = PublishSubject.create<Any>()

    init {
        action.startWith(Unit).switchMap {
            service.getTrendingAndroidRepositories().toObservable()
                    .map<BrowseUiState> { BrowseUiState.Success(it.repositories) }
                    .startWith(BrowseUiState.Loading)
                    .onErrorReturn { BrowseUiState.Failure(it.localizedMessage) { action.onNext(Unit) } }
        }.subscribe { uiState.postValue(it) }
    }

}
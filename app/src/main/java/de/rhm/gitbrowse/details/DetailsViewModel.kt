package de.rhm.gitbrowse.details

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import de.rhm.gitbrowse.api.GithubService
import io.reactivex.subjects.PublishSubject

class DetailsViewModel(service: GithubService) : ViewModel() {

    val uiState = MutableLiveData<DetailsUiState>()
    private val actions = PublishSubject.create<FetchSubscribersAction>()

    init {
        actions
                .switchMap { action ->
                    service.getSubscribers(action.name).toObservable()
                            .map<DetailsUiState> { DetailsUiState.Success(it) }
                            .startWith(DetailsUiState.Loading)
                            .onErrorReturn { DetailsUiState.Failure(it.localizedMessage) { actions.onNext(action) } }
                }
                .startWith(DetailsUiState.Initial { actions.onNext(FetchSubscribersAction(it)) })
                .subscribe { uiState.postValue(it) }
    }

}

class FetchSubscribersAction(val name: String)
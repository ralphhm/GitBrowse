package de.rhm.gitbrowse.browse

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import de.rhm.gitbrowse.api.GithubService
import de.rhm.gitbrowse.api.model.SearchRepositoriesResponse
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import io.reactivex.Single
import io.reactivex.subjects.PublishSubject

class BrowseViewModel(service: GithubService) : ViewModel() {

    val uiState = MutableLiveData<BrowseUiState>()
    private val action = PublishSubject.create<Any>()

    init {
        action.startWith(Unit)
                .compose(ActionToState({ service.getTrendingAndroidRepositories() }, { action.onNext(Unit) }))
                .subscribe { uiState.postValue(it) }
    }

}

class ActionToState(
        private inline val call: (Any) -> Single<SearchRepositoriesResponse>,
        private inline val retryAction: () -> Unit
) : ObservableTransformer<Any, BrowseUiState> {

    override fun apply(upstream: Observable<Any>): ObservableSource<BrowseUiState> {
        return upstream.switchMap { action ->
            call.invoke(action)
                    //map success case
                    .map<BrowseUiState> { BrowseUiState.Success(it.repositories) }
                    //emit loading state while fetching
                    .toObservable().startWith(BrowseUiState.Loading)
                    //emit failure state if fetch failed providing an action that triggers another fetch
                    .onErrorReturn { BrowseUiState.Failure(it.localizedMessage, retryAction) }
        }
    }

}
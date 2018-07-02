package de.rhm.gitbrowse.browse

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import de.rhm.gitbrowse.api.model.SearchRepositoriesResponse
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject
import org.junit.Test

class ActionToStateTest {

    val call = mock<(Any) -> Single<SearchRepositoriesResponse>>()
    val retryAction = mock<() -> Unit>()
    val observer = TestObserver.create<BrowseUiState>()
    val action: Subject<Any> = PublishSubject.create()

    init {
        ActionToState(call, retryAction).apply(action).subscribe(observer)
    }

    @Test
    fun `emits loading state`() {
        whenever(call.invoke(any())).thenReturn(Single.never())
        action.onNext(Unit)
        observer.values().run {
            assert(first() is BrowseUiState.Loading)
        }
    }

    @Test
    fun `emits failure state after error`() {
        val exception = Exception()
        whenever(call.invoke(any())).thenReturn(Single.error(exception))
        action.onNext(Any())
        observer.values().run {
            assert(first() is BrowseUiState.Loading)
            assert(get(1) is BrowseUiState.Failure)
        }
    }

    @Test
    fun `emits success state after success`() {
        whenever(call.invoke(any())).thenReturn(Single.just(SearchRepositoriesResponse(emptyList())))
        action.onNext(Unit)
        observer.values().run {
            assert(first() is BrowseUiState.Loading)
            assert(get(1) is BrowseUiState.Success)
        }
    }

}
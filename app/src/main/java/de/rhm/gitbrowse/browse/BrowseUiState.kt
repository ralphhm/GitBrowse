package de.rhm.gitbrowse.browse

import de.rhm.gitbrowse.api.model.Repository

sealed class BrowseUiState {
    object Loading : BrowseUiState()
    class Failure(val reason: String?, val retryAction: () -> Unit) : BrowseUiState()
    class Success(val repositories: List<Repository>) : BrowseUiState()
}
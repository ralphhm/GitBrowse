package de.rhm.gitbrowse

import de.rhm.gitbrowse.api.model.Repository

sealed class BrowseUiState {
    object Loading : BrowseUiState()
    class Failure(val reason: String?) : BrowseUiState()
    class Success(val repositories: List<Repository>) : BrowseUiState()
}
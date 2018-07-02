package de.rhm.gitbrowse.details

import de.rhm.gitbrowse.api.model.User

sealed class DetailsUiState {
    class Initial(val fetchAction: (String) -> Unit) : DetailsUiState()
    object Loading : DetailsUiState()
    class Failure(val reason: String?, val retryAction: () -> Unit) : DetailsUiState()
    class Success(val subscribers: List<User>) : DetailsUiState()
}
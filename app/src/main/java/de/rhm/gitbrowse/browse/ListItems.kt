package de.rhm.gitbrowse.browse

import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import de.rhm.gitbrowse.R
import de.rhm.gitbrowse.api.model.Repository
import kotlinx.android.synthetic.main.item_error.*
import kotlinx.android.synthetic.main.item_repository.*

object LoadingItem : Item() {
    override fun bind(viewHolder: ViewHolder, position: Int) = Unit
    override fun getLayout() = R.layout.item_loading
}

class RepositoryItem(val repository: Repository) : Item() {

    override fun bind(viewHolder: ViewHolder, position: Int) = with(viewHolder) {
        repo_name.text = repository.name
        repo_description.text = repository.description
        forks.text = "${repository.forkCount}"
        owner_image.setImageURI(repository.owner.avatarUrl)
    }

    override fun getLayout() = R.layout.item_repository
}

class ErrorItem(val state: BrowseUiState.Failure) : Item() {

    override fun bind(viewHolder: ViewHolder, position: Int) = with(viewHolder) {
        error_info.text = itemView.resources.getString(R.string.error_loading_repos, state.reason)
        action_retry.setOnClickListener { state.retryAction.invoke() }
    }

    override fun getLayout() = R.layout.item_error
}
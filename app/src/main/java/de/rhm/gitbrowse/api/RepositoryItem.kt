package de.rhm.gitbrowse.api

import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import de.rhm.gitbrowse.R
import de.rhm.gitbrowse.api.model.Repository
import kotlinx.android.synthetic.main.item_repository.*

class RepositoryItem(val repository: Repository) : Item() {

    override fun bind(viewHolder: ViewHolder, position: Int) = with(viewHolder) {
        repo_name.text = repository.name
        repo_description.text = repository.description
        forks.text = "${repository.forkCount}"
        //TODO load avatar image
    }

    override fun getLayout() = R.layout.item_repository
}
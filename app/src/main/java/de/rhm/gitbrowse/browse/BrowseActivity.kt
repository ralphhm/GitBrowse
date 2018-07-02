package de.rhm.gitbrowse.browse

import android.arch.lifecycle.Observer
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import de.rhm.gitbrowse.R
import de.rhm.gitbrowse.api.model.Repository
import de.rhm.gitbrowse.details.DetailsActivity
import de.rhm.gitbrowse.details.EXTRA_NAME
import de.rhm.gitbrowse.details.EXTRA_SUBSCRIBERS
import kotlinx.android.synthetic.main.activity_browse.*
import kotlinx.android.synthetic.main.content_browse.*
import org.koin.android.architecture.ext.viewModel

class BrowseActivity : AppCompatActivity() {

    private val section = Section()
    private val viewModel by viewModel<BrowseViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_browse)
        setSupportActionBar(toolbar)
        content.adapter = GroupAdapter<ViewHolder>().apply {
            add(section)
            setOnItemClickListener { item, _ -> (item as? RepositoryItem)?.let { showRepositoryDetails(it.repository) } }
        }
        viewModel.uiState.observe(this, Observer { bind(it!!) })
    }

    private fun bind(state: BrowseUiState) = when (state) {
        BrowseUiState.Loading -> section.update(listOf(LoadingItem))
        is BrowseUiState.Failure -> section.update(listOf(ErrorItem(state)))
        is BrowseUiState.Success -> section.update(state.repositories.map { RepositoryItem(it) })
    }

    private fun showRepositoryDetails(repository: Repository) {
        startActivity(Intent(this, DetailsActivity::class.java).apply {
            putExtra(EXTRA_NAME, repository.fullName)
            putExtra(EXTRA_SUBSCRIBERS, repository.subscribersCount)
        })
    }

}

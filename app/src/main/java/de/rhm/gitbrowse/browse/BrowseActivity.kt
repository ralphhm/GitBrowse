package de.rhm.gitbrowse.browse

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import de.rhm.gitbrowse.R
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
        content.adapter = GroupAdapter<ViewHolder>().apply { add(section) }
        viewModel.uiState.observe(this, Observer { bind(it!!) })
    }

    private fun bind(state: BrowseUiState) = when (state) {
        BrowseUiState.Loading -> section.update(listOf(LoadingItem))
        is BrowseUiState.Failure -> section.update(listOf(ErrorItem(state.reason)))
        is BrowseUiState.Success -> section.update(state.repositories.map { RepositoryItem(it) })
    }

}

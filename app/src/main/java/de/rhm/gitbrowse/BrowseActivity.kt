package de.rhm.gitbrowse

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import de.rhm.gitbrowse.api.RepositoryItem
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
        viewModel.repositories.observe(this, Observer { bind(it!!) })
    }

    private fun bind(state: BrowseUiState) = when (state) {
        BrowseUiState.Loading -> Snackbar.make(toolbar, "Loading", Snackbar.LENGTH_LONG).show()
        is BrowseUiState.Failure -> Snackbar.make(toolbar, state.reason
                ?: "Unknown error", Snackbar.LENGTH_LONG).show()
        is BrowseUiState.Success -> section.update(state.repositories.map { RepositoryItem(it) })
    }

}

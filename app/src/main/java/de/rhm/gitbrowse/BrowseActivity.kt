package de.rhm.gitbrowse

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import de.rhm.gitbrowse.api.RepositoryItem
import kotlinx.android.synthetic.main.activity_browse.*
import kotlinx.android.synthetic.main.content_browse.*
import org.koin.android.ext.android.inject

class BrowseActivity : AppCompatActivity() {

    private val section = Section()
    private val viewModel by inject<BrowseViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_browse)
        setSupportActionBar(toolbar)
        content.adapter = GroupAdapter<ViewHolder>().apply { add(section) }
        viewModel.repositories.observe(this, Observer { section.update(it!!.map { RepositoryItem(it) }) })
    }

}

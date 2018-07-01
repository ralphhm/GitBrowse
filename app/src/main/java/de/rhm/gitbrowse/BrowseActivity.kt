package de.rhm.gitbrowse

import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import de.rhm.gitbrowse.api.GithubService
import de.rhm.gitbrowse.api.RepositoryItem
import de.rhm.gitbrowse.api.model.Repository
import kotlinx.android.synthetic.main.activity_browse.*
import kotlinx.android.synthetic.main.content_browse.*
import org.koin.android.ext.android.inject

class BrowseActivity : AppCompatActivity() {

    private val section = Section()
    private val service by inject<GithubService>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_browse)
        setSupportActionBar(toolbar)
        content.adapter = GroupAdapter<ViewHolder>().apply { add(section) }
        object : AsyncTask<Any, Any, List<Repository>>() {
            override fun doInBackground(vararg params: Any?): List<Repository> {
                return service.getTrendingAndroidRepositories().execute().body()?.repositories
                        ?: emptyList()
            }

            override fun onPostExecute(result: List<Repository>?) = section.update(result!!.map { RepositoryItem(it) })

        }.execute()
    }

}

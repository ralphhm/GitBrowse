package de.rhm.gitbrowse.details

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View.GONE
import android.view.View.VISIBLE
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import de.rhm.gitbrowse.R
import de.rhm.gitbrowse.api.model.User
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.content_details.*
import kotlinx.android.synthetic.main.item_error.view.*
import kotlinx.android.synthetic.main.item_subscriber.*
import org.koin.android.architecture.ext.viewModel

const val EXTRA_NAME = "name"
const val EXTRA_SUBSCRIBERS = "subscribers"

class DetailsActivity : AppCompatActivity() {

    private val section = Section()
    private val viewModel by viewModel<DetailsViewModel>()
    private val name by lazy { intent.getStringExtra(EXTRA_NAME) }
    private val subscribersCount by lazy { intent.getIntExtra(EXTRA_SUBSCRIBERS, 0) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = name
        subscribers.text = "$subscribersCount"
        content.adapter = GroupAdapter<ViewHolder>().apply { add(section) }
        viewModel.uiState.observe(this, Observer { bind(it!!) })
    }

    private fun bind(state: DetailsUiState) {
        error_state.visibility = if (state is DetailsUiState.Failure) VISIBLE else GONE
        loading_state.visibility = if (state is DetailsUiState.Loading) VISIBLE else GONE
        content.visibility = if (state is DetailsUiState.Success) VISIBLE else GONE
        when (state) {
            is DetailsUiState.Success -> section.update(state.subscribers.map { SubscriberItem(it) })
            is DetailsUiState.Initial -> state.fetchAction.invoke(name)
            is DetailsUiState.Failure -> error_state.apply {
                action_retry.setOnClickListener { state.retryAction.invoke() }
                error_info.text = state.reason
            }
        }
    }

}

class SubscriberItem(val user: User) : Item() {
    override fun bind(viewHolder: ViewHolder, position: Int) = with(viewHolder) {
        subscriber.text = user.login
    }

    override fun getLayout() = R.layout.item_subscriber

}

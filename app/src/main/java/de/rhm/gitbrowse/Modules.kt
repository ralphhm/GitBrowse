package de.rhm.gitbrowse

import com.squareup.moshi.Moshi
import de.rhm.gitbrowse.api.GithubService
import de.rhm.gitbrowse.browse.BrowseViewModel
import de.rhm.gitbrowse.details.DetailsViewModel
import io.reactivex.schedulers.Schedulers
import org.koin.android.architecture.ext.viewModel
import org.koin.dsl.module.applicationContext
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

val AppModule = applicationContext {

    bean<Moshi> { Moshi.Builder().build() }

    bean<Converter.Factory> { MoshiConverterFactory.create(get()) }

    bean<GithubService> {
        Retrofit.Builder().baseUrl("https://api.github.com")
                .addConverterFactory(get())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build().create(GithubService::class.java)
    }

    viewModel { BrowseViewModel(get()) }

    viewModel { DetailsViewModel(get()) }

}
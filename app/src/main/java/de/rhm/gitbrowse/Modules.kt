package de.rhm.gitbrowse

import com.squareup.moshi.Moshi
import de.rhm.gitbrowse.api.GithubService
import org.koin.android.architecture.ext.viewModel
import org.koin.dsl.module.applicationContext
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val AppModule = applicationContext {

    bean<Moshi> { Moshi.Builder().build() }

    bean<Converter.Factory> { MoshiConverterFactory.create(get()) }

    bean<GithubService> {
        Retrofit.Builder().baseUrl("https://api.github.com")
                .addConverterFactory(get())
                .build().create(GithubService::class.java)
    }

    viewModel { BrowseViewModel(get()) }

}
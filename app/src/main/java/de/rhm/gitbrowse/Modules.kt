package de.rhm.gitbrowse

import com.squareup.moshi.Moshi
import org.koin.dsl.module.applicationContext

val AppModule = applicationContext {

    bean<Moshi> { Moshi.Builder().build() }

}
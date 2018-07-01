package de.rhm.github.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import de.rhm.gitbrowse.api.model.Repository

@JsonClass(generateAdapter = true)
class SearchRepositories(
        @Json(name = "items") val repositories: List<Repository> = emptyList()
)
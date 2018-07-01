package de.rhm.gitbrowse.api.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class SearchRepositoriesResponse(
        @Json(name = "items") val repositories: List<Repository> = emptyList()
)
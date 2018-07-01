package de.rhm.gitbrowse.api.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
class Repository(
        @Json(name = "id") val id: Int,
        @Json(name = "name") val name: String,
        @Json(name = "description") val description: String,
        @Json(name = "owner") val owner: Owner,
        @Json(name = "forks_count") val forkCount: Int
) {
    @JsonClass(generateAdapter = true)
    class Owner(
            @Json(name = "avatar_url")
            val avatarUrl: String?
    )
}
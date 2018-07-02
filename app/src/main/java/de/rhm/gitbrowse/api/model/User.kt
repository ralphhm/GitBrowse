package de.rhm.gitbrowse.api.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class User(@Json(name = "login") val login: String)
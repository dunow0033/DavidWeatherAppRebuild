package com.express.android.davidweatherapprebuild.data.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Clouds(
    val all: Int
)
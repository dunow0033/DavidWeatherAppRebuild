package com.express.android.davidweatherapprebuild.data.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)
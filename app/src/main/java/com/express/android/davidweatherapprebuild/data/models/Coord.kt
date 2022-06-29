package com.express.android.davidweatherapprebuild.data.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Coord(
    val lat: Double,
    val lon: Double
)
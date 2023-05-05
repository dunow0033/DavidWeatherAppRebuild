package com.express.android.davidweatherapprebuild.data.models

//import android.os.Parcelable
//import com.squareup.moshi.Json
//import com.squareup.moshi.JsonClass
//import kotlinx.parcelize.Parcelize
//
//@Parcelize
//@JsonClass(generateAdapter = true)
//data class Coord(
//    val lat: Double,
//    val lon: Double
//) : Parcelable


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Coord(
    @Json(name = "lat")
    val lat: Double?,
    @Json(name = "lon")
    val lon: Double?
) : Parcelable
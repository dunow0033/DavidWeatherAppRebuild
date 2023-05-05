package com.express.android.davidweatherapprebuild.data.models

//import android.os.Parcelable
//import com.squareup.moshi.Json
//import com.squareup.moshi.JsonClass
//import kotlinx.parcelize.Parcelize
//
//@Parcelize
//@JsonClass(generateAdapter = true)
//data class Wind(
//    val deg: Int,
//    val gust: Double,
//    val speed: Double
//) : Parcelable



import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Wind(
    @Json(name = "deg")
    val deg: Double?,
    @Json(name = "speed")
    val speed: Double?
) : Parcelable
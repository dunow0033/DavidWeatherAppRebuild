package com.express.android.davidweatherapprebuild.data.models

//import android.os.Parcelable
//import com.squareup.moshi.Json
//import com.squareup.moshi.JsonClass
//import kotlinx.parcelize.Parcelize
//
//@Parcelize
//@JsonClass(generateAdapter = true)
//data class Main(
//    val feels_like: Double,
//    val grnd_level: Int,
//    val humidity: Int,
//    val pressure: Int,
//    val sea_level: Int,
//    val temp: Double,
//    val temp_kf: Double,
//    val temp_max: Double,
//    val temp_min: Double
//) : Parcelable


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Main(
    @Json(name = "feels_like")
    val feelsLike: Double?,
    @Json(name = "grnd_level")
    val grndLevel: Double?,
    @Json(name = "humidity")
    val humidity: Double?,
    @Json(name = "pressure")
    val pressure: Double?,
    @Json(name = "sea_level")
    val seaLevel: Double?,
    @Json(name = "temp")
    val temp: Double?,
    @Json(name = "temp_kf")
    val tempKf: Double?,
    @Json(name = "temp_max")
    val tempMax: Double?,
    @Json(name = "temp_min")
    val tempMin: Double?
) : Parcelable
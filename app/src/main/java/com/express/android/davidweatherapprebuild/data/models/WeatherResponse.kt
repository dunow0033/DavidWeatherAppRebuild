package com.express.android.davidweatherapprebuild.data.models
//
//import android.os.Parcelable
//import com.squareup.moshi.Json
//import com.squareup.moshi.JsonClass
//import kotlinx.parcelize.Parcelize
//
//@Parcelize
//@JsonClass(generateAdapter = true)
//data class WeatherResponse(
//    val city: City,
//    val cnt: Int,
//    val cod: String,
//    val list: List<Days>,
//    val message: Int
//): Parcelable


import android.os.Parcelable
import com.express.android.davidweatherapprebuild.data.models.City
import com.express.android.davidweatherapprebuild.data.models.HourlyWeather
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class WeatherResponse(
    @Json(name = "city")
    val city: City?,
    @Json(name = "cnt")
    val cnt: Double?,
    @Json(name = "cod")
    val cod: String?,
    @Json(name = "list")
    val list: List<HourlyWeather>?,
    @Json(name = "message")
    val message: Double?
) : Parcelable
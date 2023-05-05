package com.express.android.davidweatherapprebuild.data.models

//import android.os.Parcelable
//import com.squareup.moshi.Json
//import com.squareup.moshi.JsonClass
//import kotlinx.parcelize.Parcelize
//
//@Parcelize
//@JsonClass(generateAdapter = true)
//data class Weather(
//    val description: String,
//    val icon: String,
//    val id: Int,
//    val main: String
//) : Parcelable



import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Weather(
    @Json(name = "description")
    val description: String?,
    @Json(name = "icon")
    val icon: String?,
    @Json(name = "id")
    val id: Double?,
    @Json(name = "main")
    val main: String?
) : Parcelable
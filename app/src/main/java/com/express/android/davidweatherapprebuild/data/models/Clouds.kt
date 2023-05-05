package com.express.android.davidweatherapprebuild.data.models

//import android.os.Parcelable
//import com.squareup.moshi.Json
//import com.squareup.moshi.JsonClass
//import kotlinx.parcelize.Parcelize
//
//@Parcelize
//@JsonClass(generateAdapter = true)
//data class Clouds(
//    val all: Int
//) : Parcelable


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Clouds(
    @Json(name = "all")
    val all: Double?
) : Parcelable
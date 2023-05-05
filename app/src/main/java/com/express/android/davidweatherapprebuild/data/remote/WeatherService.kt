package com.express.android.davidweatherapprebuild.data.remote

import com.express.android.davidweatherapprebuild.data.models.HourlyWeather
import com.express.android.davidweatherapprebuild.data.models.WeatherResponse
import com.express.android.davidweatherapprebuild.utils.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("forecast")
    suspend fun getWeather(
        @Query("q") cityName: String,
        @Query("appid") APIKEY: String = API_KEY,
        @Query("units") units: String = "imperial"
    ) : Response<WeatherResponse>
}
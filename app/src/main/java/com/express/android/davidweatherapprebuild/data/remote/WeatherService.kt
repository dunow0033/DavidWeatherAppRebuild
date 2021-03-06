package com.express.android.davidweatherapprebuild.data.remote

import com.express.android.davidweatherapprebuild.data.models.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("data/2.5/forecasts")
    suspend fun getWeather(
        @Query("q") cityName: String,
        @Query("appid") APIKEY: String,
        @Query("units") units: String = "imperial"
    ) : Response<WeatherResponse>
}
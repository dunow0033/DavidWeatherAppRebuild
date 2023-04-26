package com.express.android.davidweatherapprebuild.data.remote

class WeatherManager {

    private val weatherService: WeatherService
    private val retrofit = RetrofitInstance.providesRetrofit()

    init {
        weatherService = retrofit.create(WeatherService::class.java)
    }

    suspend fun getWeather(cityName: String) =
        weatherService.getWeather(cityName)
}
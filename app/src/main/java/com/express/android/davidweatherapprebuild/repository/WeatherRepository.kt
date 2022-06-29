package com.express.android.davidweatherapprebuild.repository

import android.util.Log
import com.express.android.davidweatherapprebuild.data.remote.WeatherManager
import com.express.android.davidweatherapprebuild.utils.Resource
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class WeatherRepository(private val weatherManager: WeatherManager) {

    fun getWeather(cityName: String, APIKEY: String) = flow {

        val resource = try {
            val response = weatherManager.getWeather(cityName, APIKEY)
            if(response.isSuccessful && response.body() != null) {
                Resource.Success(response.body()!!)
            } else {
                Resource.Error(response.errorBody().toString())
            }
        } catch(ex: Exception) {
            Log.d(TAG, ex.toString())
            Resource.Error(ex.toString())
        }
        emit(resource)
    }

    companion object {
        private val TAG = WeatherRepository::class.java.name
    }
}
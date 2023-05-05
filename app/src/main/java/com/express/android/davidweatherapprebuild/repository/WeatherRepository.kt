package com.express.android.davidweatherapprebuild.repository

import android.util.Log
import com.express.android.davidweatherapprebuild.data.remote.RetrofitInstance
//import com.express.android.davidweatherapprebuild.data.remote.RetrofitInstance
import com.express.android.davidweatherapprebuild.data.remote.WeatherManager
import com.express.android.davidweatherapprebuild.utils.Resource
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import java.lang.Exception

class WeatherRepository(private val weatherManager: WeatherManager) {

    //suspend fun getWeather(cityName: String) = weatherManager.getWeather(cityName)
    //suspend fun getWeather(cityName: String) = RetrofitInstance.weatherService.getWeather(cityName)

    fun getWeather(cityName: String) = flow {
        emit(Resource.Loading())
        val resource = try {
            //val response = weatherManager.getWeather(cityName)
            val response = RetrofitInstance.weatherService.getWeather(cityName)

            if (response.validResponse && response.body()?.list.isNullOrEmpty().not())
                Resource.Success(response.body()!!.list!!)
            else Resource.Error("No results found for $cityName")


//            if(response.isSuccessful && response.body() != null) {
//                Resource.Success(response.body()!!)
//            } else {
//                Resource.Error(response.errorBody().toString())
//            }
        } catch(ex: Exception) {
            Log.d(TAG, ex.toString())
            Resource.Error(ex.toString())
        }
        emit(resource)
    }

    companion object {
        private val TAG = WeatherRepository::class.java.name
    }

    private val <T>Response<T>.validResponse
        get() = isSuccessful && body() != null
}
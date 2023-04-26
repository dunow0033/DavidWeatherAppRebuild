package com.express.android.davidweatherapprebuild.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.express.android.davidweatherapprebuild.data.models.WeatherResponse
import com.express.android.davidweatherapprebuild.repository.WeatherRepository
import com.express.android.davidweatherapprebuild.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

public class WeatherViewModel(val weatherRepository: WeatherRepository): ViewModel() {

    private var _weatherData: MutableLiveData<Resource<WeatherResponse>> = MutableLiveData()
    val weatherData: LiveData<Resource<WeatherResponse>> get() = _weatherData

    fun getWeather2(cityName: String) =
        viewModelScope.launch(Dispatchers.IO) {
            _weatherData.postValue(Resource.Loading())
            val response = weatherRepository.getWeather(cityName).collect {
                _weatherData.postValue(it)
            }
        }


//    private var response: MutableLiveData<Resource<WeatherResponse>> = MutableLiveData()
//    val weatherResponse: LiveData<Resource<WeatherResponse>> get() = response

//    init {
//        getWeather(cityName = "Miami")
//    }

//    fun getWeather2(cityName: String) =
//        viewModelScope.launch {
//            response.postValue(Resource.Loading())
//            weatherRepository.getWeather(cityName).let { _response ->
//
//            if (_response.isSuccessful) {
//                response.postValue(_response.body())
//            } else {
//                //Log.d("tag", "getWeather Error: ${response.code()}")
//            }
//        }
//    }


    var response: MutableLiveData<Resource<WeatherResponse>> = MutableLiveData()
    //val weatherResponse: LiveData<Resource<WeatherResponse>> get() = response

//    init {
//        getWeather(cityName = "Miami")
//    }

    fun getWeather(cityName: String) =
        viewModelScope.launch(Dispatchers.IO) {
            response.postValue(Resource.Loading())
            weatherRepository.getWeather(cityName).collect {
                response.postValue(it)
            }
        }
}
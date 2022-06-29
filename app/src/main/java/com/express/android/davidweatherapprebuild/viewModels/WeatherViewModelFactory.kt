package com.express.android.davidweatherapprebuild.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.express.android.davidweatherapprebuild.repository.WeatherRepository

class WeatherViewModelFactory(val weatherRepository: WeatherRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return WeatherViewModel(weatherRepository) as T
    }
}
package com.express.android.davidweatherapprebuild.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.express.android.davidweatherapprebuild.R
import com.express.android.davidweatherapprebuild.data.remote.WeatherManager
import com.express.android.davidweatherapprebuild.databinding.FragmentCityBinding
import com.express.android.davidweatherapprebuild.repository.WeatherRepository
import com.express.android.davidweatherapprebuild.utils.Constants.Companion.API_KEY
import com.express.android.davidweatherapprebuild.viewModels.WeatherViewModel
import com.express.android.davidweatherapprebuild.viewModels.WeatherViewModelFactory

class CityFragment : Fragment() {

    private var _binding: FragmentCityBinding? = null
    private val binding get() = _binding!!

    private lateinit var weatherViewModel: WeatherViewModel //by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCityBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        weatherViewModel = ViewModelProvider(
            this,
            WeatherViewModelFactory(WeatherRepository(WeatherManager()))
        ).get(WeatherViewModel::class.java)

        binding.nextButton.setOnClickListener {
            val cityName = binding.etCity.text.toString()
            weatherViewModel.getWeather(cityName, API_KEY)
            findNavController().navigate(R.id.weatherFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
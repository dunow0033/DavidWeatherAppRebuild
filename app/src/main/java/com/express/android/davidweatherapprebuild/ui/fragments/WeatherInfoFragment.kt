package com.express.android.davidweatherapprebuild.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.navArgs
import androidx.fragment.app.Fragment
import com.express.android.davidweatherapprebuild.databinding.FragmentCityBinding
import com.express.android.davidweatherapprebuild.databinding.FragmentWeatherBinding
import com.express.android.davidweatherapprebuild.databinding.FragmentWeatherInfoBinding

class WeatherInfoFragment : Fragment() {

    private var _binding: FragmentWeatherInfoBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<WeatherInfoFragmentArgs>()

    private lateinit var cityName: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWeatherInfoBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cityName = args.cityName

        (activity as AppCompatActivity?)!!.supportActionBar!!.title = cityName

        with(binding) {
            tvMainTemp.text = args.selectedWeather.main?.temp.toString()
            tvFeelsLike.text = args.selectedWeather.main?.feelsLike.toString()
            tvMainWeather.text = args.selectedWeather.weather[0].main
            tvDescription.text = args.selectedWeather.weather[0].description
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
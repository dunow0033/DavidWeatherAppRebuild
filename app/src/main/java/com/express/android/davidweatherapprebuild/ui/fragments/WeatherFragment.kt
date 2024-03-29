package com.express.android.davidweatherapprebuild.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.express.android.davidweatherapprebuild.adapters.WeatherAdapter
import com.express.android.davidweatherapprebuild.data.models.HourlyWeather
import com.express.android.davidweatherapprebuild.data.remote.WeatherManager
import com.express.android.davidweatherapprebuild.databinding.FragmentWeatherBinding
import com.express.android.davidweatherapprebuild.repository.WeatherRepository
import com.express.android.davidweatherapprebuild.viewModels.WeatherViewModel
import com.express.android.davidweatherapprebuild.viewModels.WeatherViewModelFactory


class WeatherFragment : Fragment() {

    private var _binding: FragmentWeatherBinding? = null
    private val binding get() = _binding!!

    private lateinit var cityName: String
    private lateinit var weatherList: Array<HourlyWeather>

    private val args by navArgs<WeatherFragmentArgs>()

    private lateinit var weatherAdapter: WeatherAdapter

    private lateinit var weatherViewModel: WeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentWeatherBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //binding.toolbar.titl(args.cityName)

        cityName = args.cityName

        setupRecyclerView()


        //weatherList = args.myWeather

        //Navigation.findNavController(view).currentDestination?.label = cityName
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = cityName

        weatherViewModel = ViewModelProvider(
            this,
            WeatherViewModelFactory(WeatherRepository(WeatherManager()))
        ).get(WeatherViewModel::class.java)

        weatherViewModel.getWeather(cityName)

//        weatherViewModel.response.observe(viewLifecycleOwner, Observer {
//            weatherAdapter.differ.submitList(it)

//            binding.apply {
//                tvCityName.text = cityName
//                tvDescription.text = weather.description
//                tvTemperature.text = weather.temperature
//                tvWind.text = weather.wind
//
//                val forecast = weather.forecast
//                tvForecast1.text = "${forecast[0].temperature}/ ${forecast[0].wind}"
//                tvForecast2.text = "${forecast[1].temperature}/ ${forecast[1].wind}"
//                tvForecast3.text = "${forecast[2].temperature}/ ${forecast[2].wind}"
//            }
  //      })

        weatherViewModel.response.observe(viewLifecycleOwner, Observer {
            weatherAdapter.differ.submitList(it.data)
        })
    }

    private fun setupRecyclerView() = binding.rvWeather.apply {
        weatherAdapter = WeatherAdapter(cityName)
        adapter = weatherAdapter
        layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
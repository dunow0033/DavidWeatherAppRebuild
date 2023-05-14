package com.express.android.davidweatherapprebuild.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isEmpty
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.express.android.davidweatherapprebuild.R
import com.express.android.davidweatherapprebuild.data.models.HourlyWeather
import com.express.android.davidweatherapprebuild.data.remote.WeatherManager
import com.express.android.davidweatherapprebuild.databinding.FragmentCityBinding
import com.express.android.davidweatherapprebuild.repository.WeatherRepository
import com.express.android.davidweatherapprebuild.utils.Constants.Companion.API_KEY
import com.express.android.davidweatherapprebuild.utils.Resource
import com.express.android.davidweatherapprebuild.utils.State
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

        //with(weatherViewModel) {
            //state.observe(viewLifecycleOwner) {
//                if(binding.textFieldSearch. == 1) {
//                    binding.textFieldSearch.isErrorEnabled = true
//                    binding.textFieldSearch.error = "Error occurred...please try again"
//                    binding.nextButton.isEnabled = false
//                }
            //}
        //}

        //binding.textFieldSearch.isErrorEnabled

        binding.nextButton.setOnClickListener {
            val cityName = binding.etCity.text.toString()
            val bundle = bundleOf("cityName" to cityName)
            //weatherViewModel.getWeather(cityName)
            //weatherViewModel.weatherData.observe(viewLifecycleOwner) {
                //navigateToWeatherList(cityName, it.data!!.toTypedArray())
                //findNavController().navigate(CityFragmentDirections.cityFragmentToWeatherFragment(cityName))
                findNavController().navigate(R.id.cityFragment_to_WeatherFragment, bundle)
            //}
        }

//        binding.progressBar.isVisible = it is State.Loading
//        binding.nextButton.isEnabled = it !is State.Loading
    }

//    private fun navigateToWeatherList(
//        city: String, data: Array<HourlyWeather>
//    ) {
//        findNavController().navigate(
//            CityFragmentDirections.cityFragmentToWeatherFragment(
//                data,
//                city
//            )
//        )
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
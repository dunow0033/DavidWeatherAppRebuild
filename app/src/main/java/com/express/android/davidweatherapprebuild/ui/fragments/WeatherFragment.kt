package com.express.android.davidweatherapprebuild.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.express.android.davidweatherapprebuild.R
import com.express.android.davidweatherapprebuild.adapters.WeatherAdapter
import com.express.android.davidweatherapprebuild.data.remote.WeatherManager
import com.express.android.davidweatherapprebuild.databinding.FragmentWeatherBinding
import com.express.android.davidweatherapprebuild.repository.WeatherRepository
import com.express.android.davidweatherapprebuild.viewModels.WeatherViewModel
import com.express.android.davidweatherapprebuild.viewModels.WeatherViewModelFactory

class WeatherFragment : Fragment() {

    private var _binding: FragmentWeatherBinding? = null
    private val binding get() = _binding!!

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

        setupRecyclerView()

        weatherViewModel = ViewModelProvider(
            this,
            WeatherViewModelFactory(WeatherRepository(WeatherManager()))
        ).get(WeatherViewModel::class.java)

        weatherViewModel.weatherData.observe(viewLifecycleOwner, Observer {
            weatherAdapter.differ.submitList(it.data?.list)
        })
    }

    private fun setupRecyclerView() = binding.rvWeatherDays.apply {
        weatherAdapter = WeatherAdapter()
        adapter = weatherAdapter
        layoutManager = LinearLayoutManager(requireContext())
    }
}
package com.express.android.davidweatherapprebuild.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.express.android.davidweatherapprebuild.data.models.Days
import com.express.android.davidweatherapprebuild.data.models.HourlyWeather
import com.express.android.davidweatherapprebuild.databinding.ItemWeatherBinding
import com.express.android.davidweatherapprebuild.ui.fragments.WeatherFragmentDirections

class WeatherAdapter : RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {

    inner class WeatherViewHolder(val binding: ItemWeatherBinding) :
            RecyclerView.ViewHolder(binding.root)

    private val differCallback = object : DiffUtil.ItemCallback<HourlyWeather>() {
        override fun areItemsTheSame(oldItem: HourlyWeather, newItem: HourlyWeather): Boolean {
            return oldItem.wind == newItem.wind
        }

        override fun areContentsTheSame(oldItem: HourlyWeather, newItem: HourlyWeather): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        return WeatherViewHolder(
            ItemWeatherBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val day = differ.currentList[position]

        holder.binding.apply {
            tvWeatherMain.text = day.weather[0].main.toString()
            tvTemp.text = day.main!!.temp.toString()
        }

        holder.binding.rowLayout.setOnClickListener {
            holder.itemView.findNavController().navigate(WeatherFragmentDirections.hourlyWeatherFragmentToWeatherInfoFragment(day))
        }
    }
}
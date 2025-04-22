package com.example.network.core

import android.content.Context
import com.example.network.data.WeatherRepositoryImpl
import com.example.network.domain.WeatherRepository
import com.example.network.presentation.WeatherScreenViewModel
import com.example.network.provider.NetworkProvider

class Container(context: Context) {


    private val weatherApi = NetworkProvider.provideWeatherApi(
        baseUrl = "https://api.weatherapi.com/",
        tokenProvider = { null })

    private val weatherRepositoryImpl: WeatherRepository = WeatherRepositoryImpl(weatherApi)

    // Hold the ViewModels in memory
    private val weatherScreenViewModel by lazy {
        WeatherScreenViewModel(weatherRepositoryImpl)
    }

    fun provideWeatherScreenViewModel() = weatherScreenViewModel
}
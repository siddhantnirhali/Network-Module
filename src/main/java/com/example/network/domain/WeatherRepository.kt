package com.example.network.domain

import com.example.network.model.WeatherResponse

// Repository
interface WeatherRepository {
    suspend fun getWeather(city: String): Result<WeatherResponse>
}
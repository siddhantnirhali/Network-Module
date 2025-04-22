package com.example.network.provider

import com.example.network.api.WeatherApi
import com.example.network.client.RetrofitClient
import retrofit2.Retrofit

object NetworkProvider {

    private fun provideRetrofit(baseUrl: String, tokenProvider: () -> String?): Retrofit {
        return RetrofitClient.create(baseUrl, tokenProvider)
    }

    fun provideWeatherApi(baseUrl: String, tokenProvider: () -> String?): WeatherApi {
        return provideRetrofit(baseUrl, tokenProvider).create(WeatherApi::class.java)
    }
    // Add more APIs here in the future
}

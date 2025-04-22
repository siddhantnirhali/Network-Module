package com.example.network.data


import android.content.Context
import com.example.network.BuildConfig
import com.example.network.api.WeatherApi
import com.example.network.domain.WeatherRepository
import com.example.network.model.WeatherResponse
import com.example.network.model.result.ApiResult
import com.example.network.model.result.toApiResult
import java.io.IOException

class WeatherRepositoryImpl(private val weatherApi: WeatherApi) : WeatherRepository {
    private val apiKey = BuildConfig.API_KEY
    override suspend fun getWeather(city: String): Result<WeatherResponse> {

        return try {

            val response = weatherApi.getWeather(
                apiKey, city,
                days = "1"
            )
            return when (val result = response.toApiResult()) {
                is ApiResult.Success -> {
                    Result.success(result.data)
                }

                is ApiResult.Error -> {
                    Result.failure(Exception("Error ${result.code}: ${result.message}"))

                }

                is ApiResult.NetworkError -> {
                    Result.failure(Exception("Network error occurred"))
                }
            }
        } catch (e: IOException) {
            // Network-related error (like no internet)
            Result.failure(Exception("Network error occurred. Please check your connection."))
        } catch (e: Exception) {
            // Other unexpected errors
            Result.failure(Exception("Unexpected error occurred."))
        }



    }
}
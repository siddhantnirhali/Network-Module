package com.example.network.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.network.domain.WeatherRepository
import com.example.network.model.WeatherResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WeatherScreenViewModel(private val weatherRepositoryImpl: WeatherRepository) : ViewModel() {

    private val _weatherState = MutableStateFlow<WeatherUiState>(WeatherUiState.Loading)
    val weatherState: StateFlow<WeatherUiState> = _weatherState


    fun fetchWeather(city: String) {
        viewModelScope.launch {
            _weatherState.value = WeatherUiState.Loading
            val response = weatherRepositoryImpl.getWeather(city)

            _weatherState.value = if (response.isSuccess) {
                WeatherUiState.Success(response.getOrThrow())
            } else {

                if (response.isFailure) {
                    Log.d("Response", response.exceptionOrNull()?.message ?: "Unknown error")
                }
                WeatherUiState.Error(response.exceptionOrNull()?.message ?: "Unknown error")

            }
        }
    }
}

sealed class WeatherUiState {
    object Loading : WeatherUiState()
    data class Success(val weather: WeatherResponse) : WeatherUiState()
    data class Error(val message: String) : WeatherUiState()
}
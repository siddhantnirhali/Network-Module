package com.example.network.presentation

import androidx.compose.runtime.Composable
import com.example.network.core.Container

@Composable
fun NetworkApp(container: Container) {

    val viewModel = container.provideWeatherScreenViewModel()
    WeatherScreen(viewModel)
}
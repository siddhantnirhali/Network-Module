package com.example.network.presentation

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.network.model.WeatherResponse

@Composable
fun WeatherScreen(viewModel: WeatherScreenViewModel) {
    val context = LocalContext.current
    val weatherState by viewModel.weatherState.collectAsState()
    var weather by remember { mutableStateOf(WeatherResponse()) }
    var city by remember { mutableStateOf("") }

    when(weatherState){
        is WeatherUiState.Success -> weather = (weatherState as WeatherUiState.Success).weather
        is WeatherUiState.Error -> {}
        is WeatherUiState.Loading -> {}
    }
    LaunchedEffect(weatherState) {
        if (weatherState is WeatherUiState.Error) {
            Toast.makeText(context, (weatherState as WeatherUiState.Error).message, Toast.LENGTH_SHORT).show()
        }
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(

            value = city,
            placeholder = { Text("Enter city name...") },
            onValueChange = { city = it },

            )

        Button(onClick = { viewModel.fetchWeather(city) }) { Text("Fetch Weather") }

        Text(" Current Weather of ${weather.location.name}")
        Text(" Current Weather of ${weather.current.temp_c}°C")
        IconButton(onClick = { viewModel.fetchWeather(city) }) {
            Icon(
                Icons.Outlined.Refresh,
                contentDescription = "Refresh Weather"
            )
        }

    }
}
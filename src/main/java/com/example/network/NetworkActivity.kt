package com.example.network

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.network.api.WeatherApi
import com.example.network.core.Container
import com.example.network.model.WeatherResponse
import com.example.network.presentation.NetworkApp
import com.example.network.presentation.WeatherScreen
import com.example.network.provider.NetworkProvider
import com.example.network.model.result.ApiResult
import com.example.network.model.result.toApiResult
import com.example.network.ui.theme.AuthModuleTheme
import kotlinx.coroutines.launch

class NetworkActivity : ComponentActivity() {
    private val appContainer = Container(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        enableEdgeToEdge()
        setContent {
            AuthModuleTheme {
                NetworkApp(appContainer)
            }
        }
    }
}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AuthModuleTheme {
        Greeting("Android")
    }
}
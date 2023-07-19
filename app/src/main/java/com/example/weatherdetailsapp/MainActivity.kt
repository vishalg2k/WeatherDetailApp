package com.example.weatherdetailsapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.weatherdetailsapp.ui.theme.WeatherDetailsAppTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherDetailsAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                   WeatherAPI()
                }
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherAPI(viewModel: WetherViewModel = androidx.lifecycle.viewmodel.compose.viewModel()){
    var city by remember {
        mutableStateOf("")
    }
    var data by remember {
        mutableStateOf("")
    }
    Column(
        Modifier
            .fillMaxSize()
            .padding(20.dp)) {
        OutlinedTextField(value = city, onValueChange ={city = it} )
        data = viewModel.getWeatherDetails(location = city)!!
        Text(text = "$data")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WeatherDetailsAppTheme {
        Greeting("Android")
    }
}
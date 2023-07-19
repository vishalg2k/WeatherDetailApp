package com.example.weatherdetailsapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

abstract class WetherViewModel:ViewModel() {
    var errorMessage: String by mutableStateOf("")
    lateinit var data:WeatherData
    abstract var type:String?
    fun getWeatherDetails(location: String) : String? {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
//                 data = apiService.getWeather(loc = location )
                 type = data?.current?.condition?.text

            }
            catch (e: Exception) {
                throw Exception(e.message)
            }
        }
        return type
    }

}
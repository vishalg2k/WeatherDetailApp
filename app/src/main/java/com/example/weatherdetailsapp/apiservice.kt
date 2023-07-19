package com.example.weatherdetailsapp

import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("current.json?key=d890acd1152f4e0ea69171210231207")
    suspend fun getWeather(
        @Query("q") city: String,
        @Query("aqi") aqi: String
    ): WeatherData

    companion object {
        private var apiService: ApiService? = null
        fun getInstance(): ApiService {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl("https://api.weatherapi.com/v1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiService::class.java)
                Log.d("API", "New API Connection good")
            } else {
                Log.d("API_Old", "API Connection already existed")
            }
            return apiService!!
        }
    }
}
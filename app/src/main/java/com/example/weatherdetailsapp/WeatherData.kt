package com.example.weatherdetailsapp

import com.google.gson.annotations.SerializedName



data class WeatherData (

    @SerializedName("location" ) var location : Location? = Location(),
    @SerializedName("current"  ) var current  : Current?  = Current()

)

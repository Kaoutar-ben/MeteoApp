package com.example.meteoapp.Datacontracts

data class HourWeatherDate(
    val date: String,
    val temperature: String,
    val temperatureMin: String,
    val temperatureMax: String,
    val rainMeasure: String,
    val cloudLowMeasure: String,
    val cloudHighMeasure: String
)

data class WeatherDataContact(
    val placeName: String,

    val longitude: String,

    val latitude: String,

    val temperatureUnit: String,

    val windSpeedUnit: String,

    val cloudWeatherUnit: String,

    val rainWeatherUnit: String,

    val temperatureMeasure: MutableList<HourWeatherDate>
)
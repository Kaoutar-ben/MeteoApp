package com.example.meteoapp.api

data class GeocodingResponse(
    val results: List<GeocodingResult>?
)

data class GeocodingResult(
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val country: String,
    val admin1: String?
)

data class WeatherResponse(
    val latitude: Double,
    val longitude: Double,
    val hourly: HourlyData,
    val hourly_units: HourlyUnits
)

data class HourlyData(
    val time: List<String>,
    val temperature_2m: List<Double>,
    val relative_humidity_2m: List<Int>,
    val apparent_temperature: List<Double>,
    val rain: List<Double>,
    val wind_speed_10m: List<Double>
)

data class HourlyUnits(
    val temperature_2m: String,
    val relative_humidity_2m: String,
    val apparent_temperature: String,
    val rain: String,
    val wind_speed_10m: String
)
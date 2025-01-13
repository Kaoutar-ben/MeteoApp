package com.example.meteoapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfig {
    private const val WEATHER_BASE_URL = "https://api.open-meteo.com/"
    private const val GEOCODING_BASE_URL = "https://geocoding-api.open-meteo.com/"

    private val weatherRetrofit = Retrofit.Builder()
        .baseUrl(WEATHER_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val geocodingRetrofit = Retrofit.Builder()
        .baseUrl(GEOCODING_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val weatherService: WeatherApiService = weatherRetrofit.create(WeatherApiService::class.java)
    val geocodingService: WeatherApiService = geocodingRetrofit.create(WeatherApiService::class.java)
}
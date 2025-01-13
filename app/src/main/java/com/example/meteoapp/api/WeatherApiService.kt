package com.example.meteoapp.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
    @GET("v1/forecast")
    suspend fun getWeatherData(
        @Query("latitude") lat: Double,
        @Query("longitude") lon: Double,
        @Query("hourly") hourly: String = "temperature_2m,relative_humidity_2m,apparent_temperature,rain,wind_speed_10m",
        @Query("models") models: String = "meteofrance_seamless"
    ): Response<WeatherResponse>

    @GET("v1/search")
    suspend fun searchCity(
        @Query("name") cityName: String
    ): Response<GeocodingResponse>
}
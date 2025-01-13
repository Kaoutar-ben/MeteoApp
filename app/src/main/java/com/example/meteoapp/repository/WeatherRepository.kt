package com.example.meteoapp.repository

import com.example.meteoapp.api.ApiConfig
import com.example.meteoapp.api.GeocodingResponse
import com.example.meteoapp.api.WeatherResponse

sealed class Result<out T> {
    data class Success<T>(val data: T) : Result<T>()
    data class Error(val message: String) : Result<Nothing>()
    object Loading : Result<Nothing>()
}

class WeatherRepository {
    private val weatherService = ApiConfig.weatherService
    private val geocodingService = ApiConfig.geocodingService

    suspend fun searchCity(query: String): Result<GeocodingResponse> {
        return try {
            val response = geocodingService.searchCity(query)
            if (response.isSuccessful) {
                Result.Success(response.body()!!)
            } else {
                Result.Error("Erreur API: ${response.code()}")
            }
        } catch (e: Exception) {
            Result.Error("Erreur réseau: ${e.message}")
        }
    }

    suspend fun getWeatherData(lat: Double, lon: Double): Result<WeatherResponse> {
        return try {
            val response = weatherService.getWeatherData(lat, lon)
            if (response.isSuccessful) {
                Result.Success(response.body()!!)
            } else {
                Result.Error("Erreur API: ${response.code()}")
            }
        } catch (e: Exception) {
            Result.Error("Erreur réseau: ${e.message}")
        }
    }
}
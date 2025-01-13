package com.example.meteoapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meteoapp.repository.WeatherRepository
import com.example.meteoapp.repository.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {
    private val repository = WeatherRepository()

    private val _searchResults = MutableStateFlow<Result<List<String>>>(Result.Success(emptyList()))
    val searchResults: StateFlow<Result<List<String>>> = _searchResults

    fun searchCity(query: String) {
        viewModelScope.launch {
            _searchResults.value = Result.Loading
            when (val result = repository.searchCity(query)) {
                is Result.Success -> {
                    val cities = result.data.results?.map { it.name } ?: emptyList()
                    _searchResults.value = Result.Success(cities)
                }
                is Result.Error -> {
                    _searchResults.value = Result.Error(result.message)
                }
                else -> {}
            }
        }
    }
}
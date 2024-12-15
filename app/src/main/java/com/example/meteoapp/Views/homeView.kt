package com.example.meteoapp.Views

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meteoapp.Components.FavoritesPreviewComponent
import com.example.meteoapp.Components.FavoritesPreviewComponentPreview
import com.example.meteoapp.Components.WeatherPreviewComponent
import com.example.meteoapp.Components.searchBare
import com.example.meteoapp.Datacontracts.WeatherDataContact

@Composable
fun homeView(){
    val searchedCity = remember { mutableStateOf("") }
    val proposals = remember { mutableStateListOf<WeatherDataContact>() }
    val favorit = remember { mutableStateListOf<WeatherDataContact>() }

    proposals.add(WeatherDataContact(
        placeName = "Corte",
        longitude = "",
        latitude = "",
        cloudWeatherUnit = "%",
        windSpeedUnit = "km/h",
        rainWeatherUnit = "mm/m3",
        temperatureUnit = "C",
        temperatureMeasure = mutableListOf()
    ))

    favorit.add(
        WeatherDataContact(placeName = "Corte",
            longitude = "",
            latitude = "",
            cloudWeatherUnit = "%",
            windSpeedUnit = "km/h",
            rainWeatherUnit = "mm/m3",
            temperatureUnit = "C",
            temperatureMeasure = mutableListOf())
    )

    favorit.add(
        WeatherDataContact(placeName = "Corte",
            longitude = "",
            latitude = "",
            cloudWeatherUnit = "%",
            windSpeedUnit = "km/h",
            rainWeatherUnit = "mm/m3",
            temperatureUnit = "C",
            temperatureMeasure = mutableListOf())
    )

    Column(
        verticalArrangement = Arrangement.spacedBy(30.dp)
    ) {
        searchBare(
            modifier = Modifier.fillMaxWidth(),
            textField = searchedCity,
            searchBarePlaceholder = "Saisir le nom de la ville",
            description = "Recherche  Météo",
            onButtonClick={},
            onValueChange = {
                searchedCity.value = it
            }
        )

        if (proposals.isNotEmpty()){
            Text("Resultats", fontSize = 30.sp, fontWeight = FontWeight.Bold)

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(10.dp)) {
                items(items = proposals){
                    item -> WeatherPreviewComponent(
                    modifier = Modifier.fillMaxWidth(),
                    weatherDataContact= item,
                    onButtonClicked = {}
                    )
                }
            }
        }

        if(favorit.isNotEmpty()){
            Text("Favorits",fontSize = 30.sp, fontWeight = FontWeight.Bold)
            val favoriteList = remember { mutableStateOf(true) }
            LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(10.dp)) {
                items(items = favorit){
                    item -> FavoritesPreviewComponent(
                        modifier = Modifier.fillMaxWidth(),
                        weatherDataContact = item,
                        isFavorite = favoriteList
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun homeVienPreview(){
    homeView()
}
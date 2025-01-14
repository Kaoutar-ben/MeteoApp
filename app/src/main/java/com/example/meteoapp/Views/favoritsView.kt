package com.example.meteoapp.Views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import com.example.meteoapp.Datacontracts.WeatherDataContact
import androidx.compose.material.icons.filled.Delete

@Composable
fun favoritsView(){

    val favorit = remember { mutableStateListOf<WeatherDataContact>() }
    val favoriteList = remember { mutableStateOf(true) }

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


    Column (
        verticalArrangement = Arrangement.spacedBy(30.dp)
    ){
        Text("Vos Favoris")
        LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            items(items = favorit){
                    item -> FavoritesPreviewComponent(
                modifier = Modifier.fillMaxWidth(),
                weatherDataContact = item,
                isFavorite = favoriteList,
                onButtonClicked = {},
                onDeleteClicked = {
                    favorit.remove(item)
                }
            )
            }
        }
    }
}

@Composable
@Preview
fun favoritsViewPreview(){
    favoritsView()
}
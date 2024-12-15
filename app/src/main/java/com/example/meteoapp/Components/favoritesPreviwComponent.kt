package com.example.meteoapp.Components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.meteoapp.Datacontracts.WeatherDataContact

@Composable
fun FavoritesPreviewComponent(modifier: Modifier,
                            weatherDataContact: WeatherDataContact,
                            isFavorite: MutableState<Boolean>
){
    Row(modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(weatherDataContact.placeName)
        IconButton(onClick = {isFavorite.value = !isFavorite.value}) {
            if (isFavorite.value)
                Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Favorites",
                    tint = Color.Red)
            else
                Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Favorites")
        }
    }
}

@Composable
@Preview
fun FavoritesPreviewComponentPreview(){
    val favoriteList = remember { mutableStateOf(false) }
    FavoritesPreviewComponent(
        modifier = Modifier,
        weatherDataContact = WeatherDataContact(
            placeName = "Corte",
            longitude = "",
            latitude = "",
            cloudWeatherUnit = "%",
            windSpeedUnit = "km/h",
            rainWeatherUnit = "mm/m3",
            temperatureUnit = "C",
            temperatureMeasure = mutableListOf()
        ),
        isFavorite = favoriteList
    )
}
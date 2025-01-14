package com.example.meteoapp.Components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.meteoapp.Datacontracts.WeatherDataContact

@Composable
fun FavoritesPreviewComponent(
    modifier: Modifier,
    weatherDataContact: WeatherDataContact,
    isFavorite: MutableState<Boolean>,
    onButtonClicked: () -> Unit,
    onDeleteClicked: () -> Unit
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(onClick = onDeleteClicked) {
            Icon(
                imageVector = Icons.Filled.Delete,
                contentDescription = "Supprimer des favoris",
                tint = MaterialTheme.colorScheme.error
            )
        }

        Text(weatherDataContact.placeName)

        IconButton(onClick = onButtonClicked) {
            Icon(imageVector = Icons.Filled.Info, contentDescription = "Information")
        }
    }
}

@Composable
@Preview
fun FavoritesPreviewComponentPreview() {
    val favoriteList = remember { mutableStateOf(false) }
    FavoritesPreviewComponent(
        modifier = Modifier.fillMaxWidth(),
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
        isFavorite = favoriteList,
        onButtonClicked = {},
        onDeleteClicked = {}
    )
}
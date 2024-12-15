package com.example.meteoapp.Components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.meteoapp.Datacontracts.WeatherDataContact

@Composable
fun WeatherPreviewComponent(modifier: Modifier,
                       weatherDataContact: WeatherDataContact,
                       onButtonClicked:()-> Unit
                       ){
    Row(modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
        ) {
        Text(weatherDataContact.placeName)
        IconButton(onClick = onButtonClicked) {
            Icon(imageVector = Icons.Filled.Info, contentDescription = "Information")
        }
    }
}

@Composable
@Preview
fun WeatherDataContactPreview(){
    WeatherPreviewComponent(
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
        onButtonClicked = {}
    )
}
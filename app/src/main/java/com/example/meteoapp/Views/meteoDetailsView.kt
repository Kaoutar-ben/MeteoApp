package com.example.meteoapp.Views

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meteoapp.Datacontracts.HourWeatherDate
import com.example.meteoapp.Datacontracts.WeatherDataContact

@Composable
fun BoxedText(key:String,value:String){
    Row(
        horizontalArrangement = Arrangement.spacedBy(15.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier= Modifier
            .fillMaxWidth()
            .border(1.dp, Color.LightGray, RoundedCornerShape(5.dp))
            .padding(5.dp)
    ) {
        Text("${key} : ", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Text(value)
    }
}


@Composable
fun meteoDetailsView(modifier: Modifier,
                     weatherDataContact: WeatherDataContact,
                     onAddToFav:()-> Unit){
    var expanded = remember { mutableStateOf(false) }
    var optionsMap = mutableMapOf<String, HourWeatherDate>()
    val hourlyDataToShow = remember {mutableStateOf<HourWeatherDate?>(null)}

    weatherDataContact.temperatureMeasure.forEach{
        optionsMap[it.date] = it
    }
    Column (
        modifier = Modifier.padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(30.dp)){
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = weatherDataContact.placeName, fontWeight = FontWeight.Bold, fontSize = 30.sp)
            Button(onClick = onAddToFav) {
                Text("Ajouter aux favoris")
            }
        }
        Column {
            ClickableText(
                text = AnnotatedString("Choisir l'heure"),
                onClick = {expanded.value = !expanded.value},
                style = TextStyle(fontSize = 20.sp, fontStyle = FontStyle.Italic)
            )
            DropdownMenu(
                expanded = expanded.value,
                onDismissRequest =  {expanded.value = false}
            ) {
                optionsMap.forEach {
                    DropdownMenuItem(
                        text = { Text(it.key) },
                        onClick = {
                            expanded.value = false
                            hourlyDataToShow.value = it.value
                        }
                    )
                }
            }

        }
        if(hourlyDataToShow.value !== null) {
            // show the select hour data
            val hourlyWeatherData = hourlyDataToShow.value!!

            Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                BoxedText(key = "Date", value = hourlyWeatherData.date)
                BoxedText(
                    key = "Temperature",
                    value = "${hourlyWeatherData.temperature}${weatherDataContact.temperatureUnit}"
                )
                BoxedText(
                    key = "Temperature minimale",
                    value = "${hourlyWeatherData.temperatureMin}${weatherDataContact.temperatureUnit}"
                )
                BoxedText(
                    key = "Temperature maximale",
                    value = "${hourlyWeatherData.temperatureMax}${weatherDataContact.temperatureUnit}"
                )
            }
        }
    }

}

@Composable
@Preview
fun meteoDetailsViewPreview(){
    meteoDetailsView(
        modifier = Modifier.fillMaxWidth(),
        weatherDataContact = WeatherDataContact(
            placeName = "Corte",
            longitude = "",
            latitude = "",
            cloudWeatherUnit = "%",
            windSpeedUnit = "km/h",
            rainWeatherUnit = "mm/m3",
            temperatureUnit = "C",
            temperatureMeasure = mutableListOf(
                HourWeatherDate(
                    date = "2024-12-15",
                    temperature = "10",
                    temperatureMin = "4",
                    temperatureMax = "12",
                    rainMeasure = "Null",
                    cloudLowMeasure = "none",
                    cloudHighMeasure = "none"
                )
            )),
        onAddToFav = {}
    )
}
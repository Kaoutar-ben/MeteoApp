package com.example.meteoapp.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.meteoapp.Datacontracts.HourWeatherDate
import com.example.meteoapp.Datacontracts.WeatherDataContact
import com.example.meteoapp.Views.favoritsView
import com.example.meteoapp.Views.homeView
import com.example.meteoapp.Views.meteoDetailsView

data object  Routes{
    val HOME_PAGE = "home"
    val FAVORIS = "favoris"
    val METEO_DETAILS = "details"
}

@Composable
fun NavigationGraph(navController: NavHostController, modifier: Modifier){
    NavHost(
        navController = navController,
        startDestination = "favoris",
        modifier = modifier
    ){
        composable(route = Routes.FAVORIS ){
            favoritsView()
        }

        composable(route = Routes.HOME_PAGE ){
            homeView()
        }

        composable(route = Routes.METEO_DETAILS) {
            meteoDetailsView(
                modifier = Modifier,
                weatherDataContact = WeatherDataContact(
                    placeName = "Paris",
                    longitude = "2.3522",
                    latitude = "48.8566",
                    cloudWeatherUnit = "%",
                    windSpeedUnit = "km/h",
                    rainWeatherUnit = "mm",
                    temperatureUnit = "°C",
                    temperatureMeasure = mutableListOf(
                        HourWeatherDate(
                            date = "2024-12-17T06:00",
                            temperature = "8",
                            temperatureMin = "2",
                            temperatureMax = "13",
                            rainMeasure = "0",
                            cloudLowMeasure = "10%",
                            cloudHighMeasure = "20%"
                        )
                    )
                ),
                onAddToFav = { /* Action à définir */ }
            )
        }

    }

}
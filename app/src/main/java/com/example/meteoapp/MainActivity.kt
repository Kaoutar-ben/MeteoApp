package com.example.meteoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.meteoapp.Navigation.NavigationGraph
import com.example.meteoapp.Navigation.Routes
import com.example.meteoapp.ui.theme.MeteoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MeteoAppTheme {
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                Scaffold(
                    bottomBar = {
                        NavigationBar {
                            NavigationBarItem(
                                selected = currentRoute == Routes.HOME_PAGE,
                                onClick = {
                                    navController.navigate(Routes.HOME_PAGE) {
                                        popUpTo(Routes.HOME_PAGE) { inclusive = true }
                                    }
                                },
                                icon = {
                                    Icon(Icons.Filled.Home, contentDescription = "Accueil")
                                },
                                label = { Text("Accueil") }
                            )

                            NavigationBarItem(
                                selected = currentRoute == Routes.FAVORIS,
                                onClick = {
                                    navController.navigate(Routes.FAVORIS) {
                                        popUpTo(Routes.FAVORIS) { inclusive = true }
                                    }
                                },
                                icon = {
                                    Icon(Icons.Filled.Favorite, contentDescription = "Favoris")
                                },
                                label = { Text("Favoris") }
                            )

                            NavigationBarItem(
                                selected = currentRoute == Routes.METEO_DETAILS,
                                onClick = {
                                    navController.navigate(Routes.METEO_DETAILS) {
                                        popUpTo(Routes.METEO_DETAILS) { inclusive = true }
                                    }
                                },
                                icon = {
                                    Icon(Icons.Filled.Info, contentDescription = "Détails Météo")
                                },
                                label = { Text("Détails") }
                            )
                        }
                    }
                ) { paddingValues ->
                    NavigationGraph(
                        navController = navController,
                        modifier = Modifier.padding(paddingValues)
                    )
                }
            }
        }
    }
}
package com.example.meteoapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.meteoapp.Navigation.NavigationGraph
import com.example.meteoapp.Navigation.Routes
import com.example.meteoapp.ui.theme.MeteoAppTheme
import kotlin.math.log
import kotlin.math.log2

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MeteoAppTheme {
                val navController = rememberNavController()

                NavigationGraph(
                    navController = navController,
                    modifier = Modifier
                )
                NavigationBar {
                    NavigationBarItem(
                        selected = false,
                        onClick = {
                            Log.d(tag)
                        }
                    )
                }
            }
        }
    }
}
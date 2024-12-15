package com.example.meteoapp.Components

import android.util.Log
import android.widget.Button
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun getLocation(
    modifier: Modifier,
    onButtonClicked:()-> Unit
){
    Button(modifier = modifier, onClick = onButtonClicked) {
        Row (
            verticalAlignment = Alignment.CenterVertically
        ){
            Text("Localiser")
            Icon(imageVector = Icons.Filled.LocationOn,
                contentDescription = "Localisation")
        }

    }
}



@Composable
@Preview
fun getLocationPreview(){
    getLocation(
        modifier = Modifier,
        onButtonClicked = {
            Log.d("info", "Button clicked")
        }
        )
}
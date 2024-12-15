package com.example.meteoapp.Components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.HistoricalChange
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.tooling.preview.Preview
import org.w3c.dom.Text

@Composable
fun searchBare(
    modifier : Modifier,
    textField: MutableState<String>,
    searchBarePlaceholder: String,
    description: String,
    onButtonClick:() -> Unit,
    onValueChange: (String) -> Unit){
    Row (modifier = modifier,
        horizontalArrangement = Arrangement.Center
        ){
        OutlinedTextField(
            value = textField.value,
            onValueChange = onValueChange,
            placeholder = { Text(searchBarePlaceholder) }
        )

        IconButton(onClick = onButtonClick) {
            Icon(imageVector = Icons.Filled.Search,
                contentDescription = description)
        }
    }
}

@Composable
@Preview
fun SearBarePreview():Unit{
    val searchedCity = remember { mutableStateOf("") }
    searchBare(
        modifier = Modifier.fillMaxSize(),
        textField = searchedCity,
        searchBarePlaceholder = "Saisir le nom de la ville",
        description = "Recherche  Météo",
        onButtonClick={
            Log.d("info", "Searched city :, ${searchedCity.value}") },
        onValueChange = {
            searchedCity.value = it
        }
    )
}
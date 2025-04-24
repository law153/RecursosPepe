package com.recursospepe.tutorial.screens.Index

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(navigateToSolicitudes: () -> Unit, navigateToArchivos: () -> Unit, navigateToIndex: () -> Unit){
    Column(modifier = Modifier
        .padding(all = 2.dp)
        .fillMaxSize()
        .background(Color.Red))
    {
        Text("Texto",
        modifier = Modifier.background(Color.White),
            color = MaterialTheme.colorScheme.onBackground)

        Button( onClick = { navigateToSolicitudes() }) {
            Text("Navegar a Solicitudes")
        }

        Button( onClick = { navigateToIndex() }) {
            Text("Navegar a Index")
        }
    }
}
package com.recursospepe.tutorial

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CrearCuentaScreen(navigateToHome: () -> Unit){
    Column(modifier = Modifier.
    padding(all = 2.dp).
    fillMaxSize().
    background(Color.Yellow))
    {
        Text("Crear cuenta")

        Button( onClick = { navigateToHome() }) {
            Text("Navegar a Crear cuenta")
        }
    }
}
package com.recursospepe.tutorial.screens.Solicitudes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.recursospepe.tutorial.models.TopBarConBackButton

@Composable
fun MostrarSolicitudScreen(navController: NavController){

    Scaffold(
        topBar = {
            TopBarConBackButton(navController = navController, title = "Detalle de Solicitud")
        }
    ) { innerPadding ->
        Column (modifier = Modifier.padding(innerPadding)){
            Text("Texto Ejemplo")
        }
    }
}
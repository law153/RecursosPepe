package com.recursospepe.tutorial.screens.Solicitudes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.recursospepe.tutorial.models.TopBarConBackButton

@Composable
fun CrearSolicitudScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopBarConBackButton(navController = navController, title = "Crear solicitud")
        }
    ) { innerPadding ->
        Column (
            modifier = Modifier.padding(innerPadding).
            fillMaxSize()
        ) {

        }
    }
}
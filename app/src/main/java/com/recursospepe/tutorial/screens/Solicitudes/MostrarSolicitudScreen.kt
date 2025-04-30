package com.recursospepe.tutorial.screens.Solicitudes

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.recursospepe.tutorial.models.TopBarConBackButton

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MostrarSolicitudScreen(navController: NavController){

    Scaffold(
        topBar = {
            TopBarConBackButton(navController = navController, title = "Detalle de Solicitud")
        }
    ) {
        Text("Solicitud 1")
    }
}
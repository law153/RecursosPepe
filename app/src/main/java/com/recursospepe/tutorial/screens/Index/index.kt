package com.recursospepe.tutorial.screens.Index

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue


@Composable
fun IndexScreen(navigateToLogin: () -> Unit, navigateToCrearCuenta: () -> Unit){
    var rol by remember { mutableStateOf(0) }

    Column(modifier = Modifier.
    fillMaxSize().

    windowInsetsPadding(WindowInsets.statusBars).
    background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        //Titulo
        Row( modifier = Modifier.background(Color.Gray) .fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically )  {
            Text(
                text = "Recursos Pepe",
                fontSize = 25.sp,
                lineHeight = 50.sp,
                textAlign = TextAlign.Center,
                fontWeight = Bold)
        }
        //Foto
        Row {
            Text(
                text = "Foto",
                fontSize = 25.sp,
                lineHeight = 50.sp,
                color = Color.Black)
        }
        //Nombre
        Row {
            Text(
                text = "Nombre",
                fontSize = 25.sp,
                lineHeight = 50.sp,
                color = Color.Black)
        }

        //Rol(temporal)
        Row {
            Text(
                text = if (rol == 0) "Uste es user" else "Uste es admin",
                fontSize = 25.sp,
                lineHeight = 50.sp,
                color = Color.Black
            )
        }
        //Sueldo
        Row(modifier = Modifier.background(Color.LightGray) .fillMaxWidth()) {
            Text(
                text = "$ Mucha plata",
                fontSize = 25.sp,
                lineHeight = 50.sp,
                fontWeight = Bold,
                color = Color.Black)


        }
        Row(modifier = Modifier.background(Color.LightGray) .fillMaxWidth()) {
            Text(
                text = "Fecha Facturación:",
                fontSize = 15.sp,
                lineHeight = 50.sp,
                color = Color.Black)
        }
        Spacer(modifier = Modifier.height(10.dp))
        //Documentos cargados
        Row (modifier = Modifier.background(Color.LightGray) .fillMaxWidth()){
            Text(
                text = "Tus documentos son:",
                fontSize = 25.sp,
                lineHeight = 50.sp,
                fontWeight = Bold,
                color = Color.Black)

        }
        Row(modifier = Modifier.background(Color.LightGray) .fillMaxWidth()) {
            Text(
                text = "Documento 1",
                fontSize = 15.sp,
                lineHeight = 50.sp,
                color = Color.Black)
        }
        Spacer(modifier = Modifier.height(10.dp))
        //Notificaciones recientes
        Row(modifier = Modifier.background(Color.LightGray) .fillMaxWidth()) {
            Text(
                text = "Tus notis son:",
                fontSize = 25.sp,
                lineHeight = 50.sp,
                fontWeight = Bold,
                color = Color.Black)
        }
        Row(modifier = Modifier.background(Color.LightGray) .fillMaxWidth()) {
            Text(
                text = "Noti 1",
                fontSize = 15.sp,
                lineHeight = 50.sp,
                color = Color.Black)
        }
        Spacer(modifier = Modifier.height(10.dp))
        //NavBar
        Row {
            Button( onClick = { navigateToLogin() }, ) {
                Text("Cerrar sesión")
            }
        }

        Row {
            Button( onClick = { navigateToCrearCuenta() }, ) {
                Text("Crear Cuenta")
            }
        }

        Row {
            Button(onClick = {
                rol = if (rol == 0) 1 else 0
            }) {
                Text("Cambiar rol")
            }
        }


    }
}
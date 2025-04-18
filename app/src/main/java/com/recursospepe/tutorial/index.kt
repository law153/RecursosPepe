package com.recursospepe.tutorial

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun IndexScreen(navigateToHome: () -> Unit){
    Column(modifier = Modifier.
    padding(all = 2.dp).
    fillMaxSize().

    background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        //Titulo
        Row( modifier = Modifier.background(Color.LightGray) .fillMaxWidth(), horizontalArrangement = Arrangement.Center )  {
            Text(
                text = "Recursos Pepe",
                fontSize = 25.sp,
                lineHeight = 50.sp,
                textAlign = TextAlign.Center)
        }
        //Foto
        Row {
            Text(
                text = "Foto",
                fontSize = 25.sp,
                lineHeight = 50.sp)
        }
        //Nombre
        Row {
            Text(
                text = "Nombre",
                fontSize = 25.sp,
                lineHeight = 50.sp)
        }
        //Sueldo
        Row {
            Text(
                text = "$ Mucha plata",
                fontSize = 25.sp,
                lineHeight = 50.sp)


        }
        Row {
            Text(
                text = "Fecha Facturación:",
                fontSize = 25.sp,
                lineHeight = 50.sp)
        }
        //Documentos cargados
        Row {
            Text(
                text = "Tus documentos son:",
                fontSize = 25.sp,
                lineHeight = 50.sp)

        }
        Row {
            Text(
                text = "Documento 1",
                fontSize = 25.sp,
                lineHeight = 50.sp)
        }
        //Notificaciones recientes
        Row {
            Text(
                text = "Tus notis son:",
                fontSize = 25.sp,
                lineHeight = 50.sp)
        }
        Row {
            Text(
                text = "Noti 1",
                fontSize = 25.sp,
                lineHeight = 50.sp)
        }
        //NavBar
        Row {
            Button( onClick = { navigateToHome() }, ) {
                Text("Navegar a Crear cuenta")
            }
        }


    }
}
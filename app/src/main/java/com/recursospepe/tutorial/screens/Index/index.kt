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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.recursospepe.tutorial.models.DocumentoDataClass
import com.recursospepe.tutorial.models.DocumentoItem
import com.recursospepe.tutorial.models.SolicitudDataClass
import com.recursospepe.tutorial.models.SolicitudItem
import com.recursospepe.tutorial.screens.Solicitudes.SolicitudesList


@Composable
fun IndexScreen(navigateToLogin: () -> Unit, navigateToCrearCuenta: () -> Unit, navigateToDocumentos: () -> Unit ){
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
        //Interfaz user
        if(rol == 0){
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
        }

        //Interfaz admin
        if(rol == 1){
            //Documentos pendientes
            Row (modifier = Modifier.background(Color.LightGray) .fillMaxWidth()){
                Text(
                    text = "Documentos pendientes:",
                    fontSize = 25.sp,
                    lineHeight = 50.sp,
                    fontWeight = Bold,
                    color = Color.Black)

            }
            val documentos1 = listOf(
                DocumentoDataClass(2, "Vacaciones", "07-05-2025", "Toma de vacaciones el proximo mes", "vacaciones.pdf", 2, 2, "Media")
            )
            DocumentosList(documentos1, navigateToDocumentos)
            //Documentos realizados
            Row(modifier = Modifier.background(Color.LightGray) .fillMaxWidth()) {
                Text(
                    text = "Documentos realizados:",
                    fontSize = 25.sp,
                    lineHeight = 50.sp,
                    fontWeight = Bold,
                    color = Color.Black)
            }
            val documentos2 = listOf(
                DocumentoDataClass(3, "Renuncia", "09-05-2025", "Anuncio de renuncia la proxima semana", "renuncia.pdf", 1, 3, "Alta")
            )
            DocumentosList(documentos2, navigateToDocumentos)

        }

        Spacer(modifier = Modifier.height(10.dp))


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

@Composable
fun DocumentosList(documentos: List<DocumentoDataClass>, navigateToMostrarDocumentoScreen: () -> Unit) {
    LazyColumn {
        items(documentos) { documento ->
            DocumentoItem(documento, navigateToMostrarDocumentoScreen)
        }
    }
}
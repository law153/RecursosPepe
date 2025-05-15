package com.recursospepe.tutorial.screens.Solicitudes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.recursospepe.tutorial.Funciones.CustomSearchBar
import com.recursospepe.tutorial.models.SolicitudDataClass
import com.recursospepe.tutorial.models.SolicitudItem
import com.recursospepe.tutorial.Funciones.BotonFlotante

@Composable
fun SolicitudesScreen(navigateToMostrarSolicitudScreen: () -> Unit,
                      navigateToCrearSolicitudScreen: () -> Unit,
                      navigateToAdminSolicitudScreen: () -> Unit)
{
    var searchText by remember { mutableStateOf("") }
    var showSearchBar by remember { mutableStateOf(true) }

    Column(modifier = Modifier
        .padding(all = 2.dp)
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background)
        .windowInsetsPadding(WindowInsets.statusBars)
    )
    {

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        )
        {
            Text(text = "Tus solicitudes",
                fontSize = 20.sp,
                modifier = Modifier.padding(all = 8.dp))


            BotonFlotante{
                navigateToCrearSolicitudScreen()
            }
        }

        CustomSearchBar(
            isVisible = showSearchBar,
            query = searchText,
            onQueryChange = { searchText = it },
            placeholder = "Buscar documentos..."
        )

        val solicitudes = listOf(
            SolicitudDataClass("Solicitud de Certificado", "Necesito un certificado de residencia para trámites bancarios.", "En revisión", "22-04-2025"),
            SolicitudDataClass("Renovación de contrato", "Se solicita la renovación del contrato de arriendo por 12 meses más.", "Aprobada", "20-04-2025"),
            SolicitudDataClass("Solicitud de vacaciones", "Solicito vacaciones desde el 10 al 25 de mayo.", "Rechazada", "18-04-2025")
        )
        SolicitudesList(solicitudes, navigateToMostrarSolicitudScreen)


        //NAVEGAR A ADMIN
        Button(onClick = {
                navigateToAdminSolicitudScreen()
                },
            modifier = Modifier.fillMaxWidth()
            ) {
            Text("Navegar a Admin")
        }

    }
}



@Composable
fun SolicitudesList(solicitudes: List<SolicitudDataClass>, navigateToMostrarSolicitudScreen: () -> Unit) {
    LazyColumn {
        items(solicitudes) { solicitud ->
            SolicitudItem(solicitud, navigateToMostrarSolicitudScreen)
        }
    }
}
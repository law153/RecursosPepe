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
import androidx.compose.foundation.layout.windowInsetsPadding
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

@Composable
fun AdminSolicitudScreen(navigateToSolicitudesScreen: () -> Unit){

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
        }

        CustomSearchBar(
            isVisible = showSearchBar,
            query = searchText,
            onQueryChange = { searchText = it },
            placeholder = "Buscar documentos..."
        )


        //NAVEGAR A EMPLEADO
        Button(onClick = {
            navigateToSolicitudesScreen()
        },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Navegar a Empleado")
        }

    }
}
package com.recursospepe.tutorial.Funciones

import androidx.compose.material.icons.Icons
import  androidx.compose.material.icons.filled.Download
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.runtime.Composable

@Composable
fun BotonDescargar(onClick: () -> Unit){
    SmallFloatingActionButton(
        onClick = { onClick() },
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.primary
    ) {
        Icon(Icons.Filled.Download, "Boton Flotante descargar")
    }
}
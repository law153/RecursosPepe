package com.recursospepe.tutorial.screens.Solicitudes

import android.content.Context
import android.net.Uri
import android.provider.OpenableColumns
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.recursospepe.tutorial.Funciones.SelectorOpcion
import com.recursospepe.tutorial.Funciones.TopBarConBackButton

@Composable
fun CrearSolicitudScreen(navController: NavController) {
    var asunto by remember { mutableStateOf("") }
    var detalles by remember { mutableStateOf("") }
    val maxCaracteresAsunto = 50
    val maxCaracteresDetalles = 500

    //Variables de archivo
    val context = LocalContext.current
    var archivoUri by remember { mutableStateOf<Uri?>(null) }
    var nombreArchivo by remember { mutableStateOf("") }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        archivoUri = uri
        nombreArchivo = obtenerNombreArchivo(context, uri)
    }

    Scaffold(
        topBar = {
            TopBarConBackButton(navController = navController, title = "Crear solicitud")
        }
    ) { innerPadding ->
        Column (
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SelectorOpcion(listOf("Salud","Vacaciones", "Dias Libres", "Legal/Administrativo", "Otros"), "Seleccionar tipo de Solicitud")

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = asunto,
                onValueChange = {
                    if (it.length <= maxCaracteresAsunto) {
                        asunto = it
                    }
                },
                label = { Text("Asunto") },
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "${asunto.length} / $maxCaracteresAsunto caracteres",
                modifier = Modifier.padding(top = 8.dp).
                align(Alignment.Start),
                style = MaterialTheme.typography.bodySmall
            )


            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = detalles,
                onValueChange = {
                    if (it.length <= maxCaracteresDetalles) {
                        detalles = it
                    }
                },
                label = { Text("Detalles") },
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "${detalles.length} / $maxCaracteresDetalles caracteres",
                modifier = Modifier.padding(top = 8.dp).
                align(Alignment.Start),
                style = MaterialTheme.typography.bodySmall
            )


            Spacer(modifier = Modifier.height(16.dp))

            Card(onClick = {
                    launcher.launch("*/*")
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Adjuntar archivo (Opcional)",
                    modifier = Modifier.
                    padding(all = 20.dp))
            }

            archivoUri?.let {uri ->
                Text(
                    text = "Archivo seleccionado: $nombreArchivo",
                    modifier = Modifier.padding(top = 8.dp)
                )
            }


            Button(onClick = {},
                modifier = Modifier.
                    align(Alignment.End).
                    padding(all = 15.dp))
            {
                Text("Crear solicitud")
            }

        }
    }
}

fun obtenerNombreArchivo(context: Context, uri: Uri?): String {
    uri ?: return ""
    var nombre = ""

    val cursor = context.contentResolver.query(
        uri, null, null, null, null
    )
    cursor?.use {
        if (it.moveToFirst()) {
            val index = it.getColumnIndex(OpenableColumns.DISPLAY_NAME)
            if (index != -1) {
                nombre = it.getString(index)
            }
        }
    }
    return nombre
}
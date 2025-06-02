package com.recursospepe.tutorial.screens.Documentos

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.recursospepe.tutorial.Funciones.SelectorOpcion
import com.recursospepe.tutorial.Funciones.TopBarConBackButton
import com.recursospepe.tutorial.models.dataclass.UsuarioDataClass
import com.recursospepe.tutorial.models.items.UsuarioItem
import com.recursospepe.tutorial.screens.Solicitudes.obtenerNombreArchivo

@Composable
fun MostrarDocumentoScreen(navController: NavController){
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
            TopBarConBackButton(navController = navController, title = "Subir un documento")
        }
    ) { innerPadding ->
        Column(modifier = Modifier.
        fillMaxSize().
        background(MaterialTheme.colorScheme.background).
        padding(innerPadding).
        windowInsetsPadding(WindowInsets.statusBars),
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            //Card del empleado
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            )
            {
                Text(text = "Documento",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(all = 8.dp))
            }
            val usuario = listOf(
                UsuarioDataClass(1, "Tulio", "Triviño", "tulio@gmail.com", "123aaa", "Los Camarones 3087", 12345678, "Operador de grua", "12/07/2024", "foto", 1)
            )
            UsuarioList(usuario)
            Spacer(modifier = Modifier.height(16.dp))

            //Cosas de archivo
            Card(onClick = {
                launcher.launch("*/*")
            },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Sube tu archivo aqui:",
                    modifier = Modifier.
                    padding(all = 20.dp))
            }

            Spacer(modifier = Modifier.height(16.dp))

            archivoUri?.let {uri ->
                Text(
                    text = "Archivo seleccionado: $nombreArchivo",
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))

            //Tipo
            SelectorOpcion(listOf("Judicial","Administrativo", "Permisos", "Informativo", "Empresarial", "Otro"), "Tipo de documento:")

            Spacer(modifier = Modifier.height(16.dp))
            //Boton
            Button(
                onClick = { {} },

            ) {
                Text("Subir documento")
            }

        }
    }


}

@Composable
fun UsuarioList(usuario: List<UsuarioDataClass>) {
    LazyColumn {
        items(usuario) { usuario ->
            UsuarioItem(usuario)
        }
    }
}
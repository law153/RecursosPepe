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
import androidx.compose.foundation.lazy.LazyColumn
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
import com.recursospepe.tutorial.models.dataclass.SolicitudDataClass
import com.recursospepe.tutorial.models.dataclass.UsuarioDataClass
import com.recursospepe.tutorial.models.items.SolicitudAdminItem

@Composable
fun AdminSolicitudScreen(navigateToSolicitudesScreen: () -> Unit,
                         navigateToMostrarAdminSolicitudes: () -> Unit){

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

        val solicitudes = listOf(
            SolicitudDataClass(
                asunto = "Solicitud de materiales",
                descripcion = "Necesito reposición de herramientas eléctricas.",
                estado = "En revisión",
                fecha = "2025-05-15"
            ),
            SolicitudDataClass(
                asunto = "Permiso especial",
                descripcion = "Solicito permiso para ausentarme el día viernes.",
                estado = "Aprobada",
                fecha = "2025-05-10"
            ),
            SolicitudDataClass(
                asunto = "Solicitud de equipo",
                descripcion = "Requiero un computador portátil para trabajo remoto.",
                estado = "Rechazada",
                fecha = "2025-04-30"
            )
        )

        val usuarios = listOf(
            UsuarioDataClass(
                idUsuario = 1,
                nombreUsuario = "Carlos",
                apellidos = "Méndez López",
                correo = "carlos.mendez@gmail.com",
                clave = "123456",
                direccion = "Av. Los Pinos 456",
                telefono = 987654321,
                cargo = "Jefe de Bodega",
                creacionCuenta = "2024-11-20",
                fotoUsario = "",
                idRol = 2
            ),
            UsuarioDataClass(
                idUsuario = 2,
                nombreUsuario = "María",
                apellidos = "Fernández Soto",
                correo = "maria.fernandez@gmail.com",
                clave = "abcdef",
                direccion = "Calle Principal 123",
                telefono = 912345678,
                cargo = "Administrativa",
                creacionCuenta = "2024-10-05",
                fotoUsario = "",
                idRol = 3
            ),
            UsuarioDataClass(
                idUsuario = 3,
                nombreUsuario = "Luis",
                apellidos = "Gómez Araya",
                correo = "luis.gomez@gmail.com",
                clave = "qwerty",
                direccion = "Av. Central 789",
                telefono = 998877665,
                cargo = "Supervisor",
                creacionCuenta = "2025-01-15",
                fotoUsario = "",
                idRol = 2
            )
        )

        AdminSolicitudesList(solicitudes, usuarios, navigateToMostrarAdminSolicitudes)

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

@Composable
fun AdminSolicitudesList(solicitudes: List<SolicitudDataClass>, usuarios: List<UsuarioDataClass>, navigateToMostrarSolicitudAdminScreen: () -> Unit) {
    LazyColumn {
        items(solicitudes.size) { index ->
            SolicitudAdminItem(solicitudes[index],
                usuarios[index],
                navigateToMostrarSolicitudAdminScreen)
        }
    }
}
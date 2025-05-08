package com.recursospepe.tutorial.screens.Solicitudes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.recursospepe.tutorial.Funciones.CustomCard
import com.recursospepe.tutorial.Funciones.PerfilEncargadoItem
import com.recursospepe.tutorial.Funciones.TopBarConBackButton

@Composable
fun MostrarSolicitudScreen(navController: NavController){
    val estado = "Rechazada"
    val tipo = "Salud"

    Scaffold(
        topBar = {
            TopBarConBackButton(navController = navController, title = "Detalle de Solicitud")
        }
    ) { innerPadding ->
        Column (
            modifier = Modifier.padding(innerPadding).
                fillMaxSize()
        ){

            // ASUNTO
            Box(modifier = Modifier.fillMaxWidth().
                        padding(vertical = 16.dp),
                contentAlignment = Alignment.Center){

                Text(text = "Dolor coquitos", style = MaterialTheme.typography.titleLarge)


            }

            Spacer(modifier = Modifier.run { height(4.dp) })

            // TIPO
            Box(modifier = Modifier.fillMaxWidth().
            padding(vertical = 16.dp),
                contentAlignment = Alignment.Center){



                Spacer(modifier = Modifier.run { height(4.dp) })

                Text(
                    text = tipo,
                    color = when (tipo) {
                        "Salud" -> Color(0xFF3F93DA)
                        "Vacaciones" -> Color(0xFFF5CA3B)
                        "Dias Libres" -> Color(0xFFB6EF81)
                        "Legal / Administrativo" -> Color(0xFF919080)
                        "Otros" -> Color(0xFF706D6D)
                        else -> Color.Gray
                    },
                    style = MaterialTheme.typography.titleMedium
                )
            }

            // DESCRIPCION
            CustomCard(texto = "Me duelen los huevos jefe, solicito pedir dia libre los siguientes 7 años. :D.",
                textStyle = MaterialTheme.typography.bodyMedium,
                label = "20-04-2025",
                archivosAdjuntos = listOf("vacaciones_solicitud.pdf", "respuesta_director.docx"))

            Spacer(modifier = Modifier.run { height(4.dp) })

            // ESTADO
            Box(modifier = Modifier.fillMaxWidth().
            padding(vertical = 16.dp),
                contentAlignment = Alignment.Center){

                Spacer(modifier = Modifier.run { height(4.dp) })

                Text(
                    text = estado,
                    color = when (estado) {
                        "Aprobada" -> Color(0xFF4CAF50)
                        "Rechazada" -> Color(0xFFF44336)
                        "En revisión" -> Color(0xFFFFC107)
                        else -> Color.Gray
                    },
                    style = MaterialTheme.typography.titleMedium
                )
            }

            //ENCARGADO
            PerfilEncargadoItem(
                nombre = "Tulio Triviño",
                rol = "Jefe de RRHH"
            )
            //COMENTARIOS

            Spacer(modifier = Modifier.run { height(4.dp) })

            CustomCard(texto = "Don Juan Carlos Bodoque. Su solicitud fue rechazada, pero no se preocupe, ¡Acaba de ser ascendido a cliente!, venga a buscar sus cosas mañana a primera hora.",
                textStyle = MaterialTheme.typography.bodyMedium,
                label = "28-04-2025")



        }
    }
}


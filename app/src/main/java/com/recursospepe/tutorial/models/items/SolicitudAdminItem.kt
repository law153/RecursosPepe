package com.recursospepe.tutorial.models.items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.recursospepe.tutorial.models.dataclass.SolicitudDataClass
import com.recursospepe.tutorial.models.dataclass.UsuarioDataClass

@Composable
fun SolicitudAdminItem(solicitud: SolicitudDataClass,
                       usuario: UsuarioDataClass,
                       navigateToMostrarSolicitudAdmin: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        onClick = { navigateToMostrarSolicitudAdmin() }
    ) {

        // FOTO
        Row(verticalAlignment = Alignment.CenterVertically){
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = "Empleado",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(64.dp)
            )

            //TEXTO

            Column(modifier = Modifier.padding(12.dp)) {

                //NOMBRE
                Text(
                    text = usuario.nombreUsuario + ' ' + usuario.apellidos,
                    style = MaterialTheme.typography.labelMedium
                )
                Spacer(modifier = Modifier.height(8.dp))

                //ASUNTO
                Text(text = solicitud.asunto, style = MaterialTheme.typography.titleMedium)

                Spacer(modifier = Modifier.run { height(4.dp) })



                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {

                    // ESTADO
                    Text(
                        text = solicitud.estado,
                        color = when (solicitud.estado) {
                            "Aprobada" -> Color(0xFF4CAF50)
                            "Rechazada" -> Color(0xFFF44336)
                            "En revisión" -> Color(0xFFFFC107)
                            else -> Color.Gray
                        },
                        style = MaterialTheme.typography.labelMedium
                    )

                    //FECHA
                    Text(
                        text = solicitud.fecha,
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }
        }
    }
}

package com.recursospepe.tutorial.models.items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.recursospepe.tutorial.models.dataclass.UsuarioDataClass

@Composable
fun UsuarioItem(usuario: UsuarioDataClass) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        //Contenedor padre
        Row(modifier = Modifier
            .fillMaxWidth()){
            Column(
                modifier = Modifier
                    .weight(0.2f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = usuario.fotoUsario)
            }

            //Columna derecha
            Column(modifier = Modifier.padding(12.dp)
                .weight(0.8f)
                .fillMaxHeight(),
                verticalArrangement = Arrangement.Center) {
                Text(text = usuario.cargo, style = MaterialTheme.typography.bodyMedium)

                Spacer(modifier = Modifier.run { height(4.dp) })
                Row{
                    Text(
                        text = usuario.nombreUsuario + " " + usuario.apellidos,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.titleMedium
                    )

                }


                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Text(
                        text = "Desde: "+usuario.creacionCuenta,
                        style = MaterialTheme.typography.labelMedium
                    )

                }
            }
        }

    }
}
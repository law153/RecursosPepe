package com.recursospepe.tutorial.models

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun DocumentoItem(documento: DocumentoDataClass, navigateToMostrarDocumento: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        onClick = { navigateToMostrarDocumento() }
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(text = documento.tipo, style = MaterialTheme.typography.titleMedium)

            Spacer(modifier = Modifier.run { height(4.dp) })

            Text(
                text = documento.descripcionDoc,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = documento.prioridad,
                    color = when (documento.prioridad) {
                        "Alta" -> Color.Red
                        "Media" -> Color.Yellow
                        "Leve" -> Color.Green
                        else -> Color.Gray
                    },
                    style = MaterialTheme.typography.labelMedium
                )
                Text(
                    text = documento.fechaSubidaDoc,
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }
    }
}
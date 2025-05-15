package com.recursospepe.tutorial.screens.Documentos

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
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.recursospepe.tutorial.models.dataclass.DocumentoDataClass
import com.recursospepe.tutorial.models.items.DocumentoItem
import com.recursospepe.tutorial.models.dataclass.UsuarioDataClass
import com.recursospepe.tutorial.screens.Index.DocumentosList

@Composable
fun DocumentosScreen(navigatoToMostrarDocumento: () -> Unit){
    Column(modifier = Modifier.
    fillMaxSize().
    background(MaterialTheme.colorScheme.background).
    padding(all = 2.dp).
    windowInsetsPadding(WindowInsets.statusBars),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        val usuario = listOf(
            UsuarioDataClass(1, "Tulio", "Triviño", "tulio@gmail.com", "123aaa", "Los Camarones 3087", 12345678, "Operador de grua", "12/07/2024", "foto", 1)
        )
        UsuarioList(usuario)
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        )
        {
            Text(text = "Tus Documentos",
                fontSize = 20.sp,
                modifier = Modifier.padding(all = 8.dp))
        }
        val documentos = listOf(
            DocumentoDataClass(1, "Licensia", "06-05-2025", "Licensia medica de Tulio", "licensia.pdf", 1, 2, "Leve"),
            DocumentoDataClass(2, "Vacaciones", "07-05-2025", "Toma de vacaciones el proximo mes", "vacaciones.pdf", 2, 2, "Media"),
            DocumentoDataClass(3, "Renuncia", "09-05-2025", "Anuncio de renuncia de Bodoque", "renuncia.pdf", 1, 3, "Alta")
        )
        DocumentosList(documentos, navigatoToMostrarDocumento )



    }
}

@Composable
fun DocumentosList(documentos: List<DocumentoDataClass>, navigateToMostrarDocumentoScreen: () -> Unit) {
    LazyColumn {
        items(documentos) { documento ->
            DocumentoItem(documento, navigateToMostrarDocumentoScreen)
        }
    }
}

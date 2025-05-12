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
import com.recursospepe.tutorial.models.DocumentoDataClass
import com.recursospepe.tutorial.models.DocumentoItem
import com.recursospepe.tutorial.models.UsuarioDataClass
import com.recursospepe.tutorial.models.UsuarioItem
import com.recursospepe.tutorial.screens.Index.DocumentosList

@Composable
fun MostrarDocumentoScreen(){
    Column(modifier = Modifier.
    fillMaxSize().
    background(MaterialTheme.colorScheme.background).
    padding(all = 2.dp).
    windowInsetsPadding(WindowInsets.statusBars),
        horizontalAlignment = Alignment.CenterHorizontally)
    {

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        )
        {
            Text(text = "Texto de ejemplo",
                fontSize = 20.sp,
                modifier = Modifier.padding(all = 8.dp))
        }
        val usuario = listOf(
            UsuarioDataClass(1, "Tulio", "Triviño", "tulio@gmail.com", "123aaa", "Los Camarones 3087", 12345678, "Operador de grua", "12/07/2024", "foto", 1)
        )
        UsuarioList(usuario)



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
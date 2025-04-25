package com.recursospepe.tutorial

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
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CrearCuentaScreen(navigateToIndex: () -> Unit) {
    var rut by remember { mutableStateOf("") }
    var dvrut by remember { mutableStateOf("") }
    var nombre by remember { mutableStateOf("") }
    var apellidos by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var direccion by remember { mutableStateOf("") }
    var cargo by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().windowInsetsPadding(WindowInsets.statusBars)
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Titulo
        Row(
            modifier = Modifier.background(Color.Gray).fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Recursos Pepe",
                fontSize = 25.sp,
                lineHeight = 50.sp,
                textAlign = TextAlign.Center,
                fontWeight = Bold
            )
        }
        //Crear cuenta nombre
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
        Text(
            text = "Crear cuenta",
            fontSize = 25.sp,
            lineHeight = 50.sp,
            color = Color.Black,
            fontWeight = Bold
        ) }

        //Rut
        Row {
            OutlinedTextField(
                value = rut,
                onValueChange = { rut = it },
                label = { Text("Rut:") },
                singleLine = true
            )

            OutlinedTextField(
                value = dvrut,
                onValueChange = { dvrut = it },
                label = { Text("Digito V:") },
                singleLine = true
            )
        }
        //Nombre
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre:") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        //Apellidos
        OutlinedTextField(
            value = apellidos,
            onValueChange = { apellidos = it },
            label = { Text("Apellidos:") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        //Telefono
        OutlinedTextField(
            value = telefono,
            onValueChange = { telefono = it },
            label = { Text("Telefono:") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        //Dirección
        OutlinedTextField(
            value = direccion,
            onValueChange = { direccion = it },
            label = { Text("Dirección:") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        //Cargo
        OutlinedTextField(
            value = cargo,
            onValueChange = { cargo = it },
            label = { Text("Cargo:") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Row {
            Button( onClick = {  }, ) {
                Text("Crear cuenta")
            }
        }

        Row {
            Button( onClick = { navigateToIndex() }, ) {
                Text("Volver a index")
            }
        }



    }

}
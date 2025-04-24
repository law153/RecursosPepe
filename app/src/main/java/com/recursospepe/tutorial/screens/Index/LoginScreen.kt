package com.recursospepe.tutorial.screens.Index

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun LoginScreen(navigateToIndex: () -> Unit){
    var user by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .padding(all = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        OutlinedTextField(value = user,
            onValueChange = {user = it},
            label = { Text(text = "Ingrese su Correo")},
            singleLine = true,
            modifier = Modifier.fillMaxWidth())

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Ingrese su contraseña") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Text(text ="¿Olvidaste tu contraseña?",
            color = MaterialTheme.colorScheme.onBackground)


        // Boton de inicio
        Button(
            onClick = { navigateToIndex() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Iniciar Sesión")
        }
    }

}
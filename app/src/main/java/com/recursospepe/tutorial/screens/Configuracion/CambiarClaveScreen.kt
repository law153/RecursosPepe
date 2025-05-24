package com.recursospepe.tutorial.screens.Configuracion

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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun CambiarClaveScreen() {
    var text by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(all = 2.dp)
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .windowInsetsPadding(WindowInsets.statusBars)
    )
    {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .padding(bottom = 30.dp, top = 30.dp),

            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,

        )
        {
            Text(
                text = "Recursos Pepe",
                fontSize = 35.sp,
                modifier = Modifier.padding(all = 8.dp)
            )

        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 55.dp, top = 40.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        )
        {
            Text(
                text = "Cambiar clave",
                fontSize = 35.sp,
                modifier = Modifier.padding(all = 8.dp)
            )

        }
        //texto
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
                .padding(horizontal = 50.dp)
        )
        {
            Text(
                text = "Clave actual",
                fontSize = 20.sp,
                modifier = Modifier.padding(all = 2.dp)
            )

        }


        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        )
        {
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Clave actual") }
            )
        }
        //texto
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
                .padding(horizontal = 55.dp)
        )
        {
            Text(
                text = "Nueva clave",
                fontSize = 20.sp,
                modifier = Modifier.padding(all = 2.dp)
            )

        }


        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        )
        {

            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Nueva clave") }
            )
        }
        //texto
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
                .padding(horizontal = 55.dp)
        )
        {
            Text(
                text = "Clave actual",
                fontSize = 20.sp,
                modifier = Modifier.padding(all = 2.dp)
            )

        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        )
        {
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Repita Nueva contraseña") }
            )
        }


        Row(
            modifier = Modifier
                .fillMaxWidth()

                .padding(top = 24.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Button(
                onClick = { /* acción */ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.LightGray,
                    contentColor = Color.Black
                )
            ) {
                Text(
                    text = "Cambiar contraseña",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(all = 2.dp)
                )
            }
        }


        }
    }







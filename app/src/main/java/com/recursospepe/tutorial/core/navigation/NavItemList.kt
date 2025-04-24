package com.recursospepe.tutorial.core.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import com.recursospepe.tutorial.models.navItem

object NavItemList {
    val NavItemList = listOf(
        navItem(label = "Inicio", Icons.Default.Home, Screen.Index.route),
        navItem(label = "Docs", Icons.Default.Email, Screen.Documentos.route),
        navItem(label = "Solicitud", Icons.Default.Notifications, Screen.Solicutdes.route),
        navItem(label = "Conf", Icons.Default.Settings, Screen.Configuracion.route)
    )
}
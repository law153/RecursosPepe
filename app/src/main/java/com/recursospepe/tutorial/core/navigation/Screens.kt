package com.recursospepe.tutorial.core.navigation

sealed class Screen(val route: String){
    object Login: Screen("Login")
    object Solicutdes: Screen("Solicitudes")
    object CrearCuenta: Screen("CrearCuenta")
    object Index: Screen("Index")
    object Documentos: Screen("Documentos")
    object Configuracion: Screen("Configuracion")
    object MostrarSolicitud: Screen("MostrarSolicitud")
    object CrearSolicitud: Screen("CrearSolicitud")
    object MostrarDocumento: Screen("MostrarDocumento")
    object AdminSolicitud: Screen("AdminSolicitud")
    object MostrarAdminSolicitud: Screen("MostrarAdminSolicitud")
    object CambiarClave: Screen("CambiarClave")
}
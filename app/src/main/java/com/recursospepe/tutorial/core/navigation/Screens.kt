package com.recursospepe.tutorial.core.navigation

sealed class Screen(val route: String){
    object Home: Screen("Home")
    object Solicutdes: Screen("Solicitudes")
}
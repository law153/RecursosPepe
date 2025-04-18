package com.recursospepe.tutorial.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.recursospepe.tutorial.HomeScreen
import com.recursospepe.tutorial.SolicitudesScreen


@Composable
fun NavigationWrapper(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route.toString()
    ){

        composable(Screen.Home.route) {
            HomeScreen(
                navigateToSolicitudes = {
                    navController.navigate(Screen.Solicutdes.route)
                },
                navigateToArchivos = {
                    navController.navigate(Screen.Solicutdes.route)
                }
            )
        }

        composable(Screen.Solicutdes.route){
            SolicitudesScreen(navigateToHome = {
                navController.navigate(Screen.Home.route)
            })
        }


    }
}
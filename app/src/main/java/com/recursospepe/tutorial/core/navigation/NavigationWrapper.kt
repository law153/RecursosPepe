package com.recursospepe.tutorial.core.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.recursospepe.tutorial.CrearCuentaScreen
import com.recursospepe.tutorial.screens.Configuracion.ConfiguracionScreen
import com.recursospepe.tutorial.screens.Documentos.DocumentosScreen
import com.recursospepe.tutorial.screens.Documentos.MostrarDocumentoScreen
import com.recursospepe.tutorial.screens.Index.IndexScreen
import com.recursospepe.tutorial.screens.Index.LoginScreen
import com.recursospepe.tutorial.screens.Solicitudes.CrearSolicitudScreen
import com.recursospepe.tutorial.screens.Solicitudes.MostrarSolicitudScreen
import com.recursospepe.tutorial.screens.Solicitudes.SolicitudesScreen


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NavigationWrapper(){
    var selectedIndex by remember { mutableIntStateOf(0) }
    val navController = rememberNavController()

    val showBottomBarRoutes = listOf(
        Screen.Index.route,
        Screen.Solicutdes.route,
        Screen.Documentos.route,
        Screen.Configuracion.route
    )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            val currentDestination = navController.currentBackStackEntryAsState().value?.destination?.route
            if (currentDestination in showBottomBarRoutes) {
                BottomNavBar(
                    navItemList = NavItemList.NavItemList,
                    selectedIndex = selectedIndex,
                    onItemSelected = { index ->
                        selectedIndex = index
                        navController.navigate(NavItemList.NavItemList[index].route) {
                            launchSingleTop = true
                            restoreState = true
                            popUpTo(Screen.Index.route) {
                                saveState = true
                            }
                        }
                    }
                )
            }
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = Screen.Login.route.toString()
        ) {

            //LOGIN

            composable(Screen.Login.route) {
                LoginScreen(navigateToIndex = {
                    navController.navigate(Screen.Index.route)
                })
            }

            //INDEX

            composable(Screen.Index.route) {
                IndexScreen(
                    navigateToLogin = {
                        navController.navigate(Screen.Login.route)
                    }, navigateToCrearCuenta = {
                        navController.navigate(Screen.CrearCuenta.route)
                    }, navigateToDocumentos = {
                        navController.navigate(Screen.Documentos.route)
                    })
            }


            ///Crear cuenta
            composable(Screen.CrearCuenta.route) {
                CrearCuentaScreen(navigateToIndex = {
                    navController.navigate(Screen.Index.route)
                })
            }


            //Documentos

            composable(Screen.Documentos.route) {
                DocumentosScreen( navigatoToMostrarDocumento = {
                    navController.navigate(Screen.MostrarDocumento.route)
                } )
            }
            composable(Screen.MostrarDocumento.route) {
                MostrarDocumentoScreen()
            }


            //Configuracion

            composable(Screen.Configuracion.route) {
                ConfiguracionScreen()
            }

            //SOLICITUDES
            composable(Screen.Solicutdes.route) {
                SolicitudesScreen(navigateToMostrarSolicitudScreen = {
                                    navController.navigate(Screen.MostrarSolicitud.route)
                                },
                                navigateToCrearSolicitudScreen = {
                                    navController.navigate(Screen.CrearSolicitud.route)
                                },
                    )
            }

            composable(Screen.CrearSolicitud.route){
                CrearSolicitudScreen(navController = navController)
            }

            //MostrarSolicitud

            composable(Screen.MostrarSolicitud.route){
                MostrarSolicitudScreen(navController = navController)
            }

        }
    }
}


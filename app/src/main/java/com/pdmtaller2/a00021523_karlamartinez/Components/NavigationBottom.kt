package com.pdmtaller2.a00021523_karlamartinez.Components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.pdmtaller2.a00021523_karlamartinez.Navigation.Rutas
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.List
import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItem(val label: String, val ruta: String, val icon: ImageVector)

@Composable
fun NavigationBottom(navController: NavController){
    val items = listOf(
        NavigationItem("Restaurantes", Rutas.HOME, Icons.Filled.Home),
        NavigationItem("Buscar", Rutas.SEARCH, Icons.Filled.Search),
        NavigationItem("Ordenes", Rutas.ORDERS, Icons.Filled.List)
    )

    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    NavigationBar {
        items.forEach{ item ->
            NavigationBarItem(
                selected = currentRoute == item.ruta,
                onClick = {
                    if (currentRoute != item.ruta){
                        navController.navigate(item.ruta){
                            popUpTo(Rutas.HOME){inclusive = false}
                            launchSingleTop = true
                        }
                    }
                },
                label = { Text(item.label)},
                icon = { Icon(item.icon, contentDescription = item.label)}
            )
        }
    }
}
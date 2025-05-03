package com.pdmtaller2.a00021523_karlamartinez.Navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pdmtaller2.a00021523_karlamartinez.Components.NavigationBottom
import com.pdmtaller2.a00021523_karlamartinez.ui.Screens.HomeScreen
import com.pdmtaller2.a00021523_karlamartinez.ui.Screens.menuScreen
import com.pdmtaller2.a00021523_karlamartinez.ui.Screens.SearchScreen
import com.pdmtaller2.a00021523_karlamartinez.ui.Screens.OrdersScreen

@Composable
fun Navegacion(){
    val navController = rememberNavController()
    val currentBackStack = navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStack.value?.destination?.route
    val showBottomBar = currentRoute in listOf(Rutas.HOME, Rutas.SEARCH, Rutas.ORDERS, Rutas.MENU)

    Scaffold (
        bottomBar = {
            if (showBottomBar) NavigationBottom(navController)
        }
    ){ innerPadding ->
        NavHost(
            navController = navController,
            startDestination =  Rutas.HOME,
            modifier = Modifier.padding(innerPadding)
        ){
            composable(Rutas.HOME){
                HomeScreen(navController)
            }
            composable(Rutas.SEARCH){
                SearchScreen()
            }
            composable(Rutas.ORDERS) {
                OrdersScreen()
            }
            composable(
                Rutas.MENU,
                arguments = listOf(navArgument("restaurantId") { type = NavType.IntType })
            ) { backStackEntry ->
                val restaurantId = backStackEntry.arguments?.getInt("restaurantId")
                restaurantId?.let {
                    menuScreen(navController, it)
                }
            }

        }

    }
}

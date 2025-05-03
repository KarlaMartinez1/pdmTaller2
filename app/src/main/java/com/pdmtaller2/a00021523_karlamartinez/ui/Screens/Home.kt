package com.pdmtaller2.a00021523_karlamartinez.ui.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.pdmtaller2.a00021523_karlamartinez.Data.categoriasRestaurante
import com.pdmtaller2.a00021523_karlamartinez.Data.restaurant
import com.pdmtaller2.a00021523_karlamartinez.Components.RestaurantCard
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.tooling.preview.Preview
import com.pdmtaller2.a00021523_karlamartinez.Components.TopBar


@Preview(showBackground = true)
@Composable
fun HomeScreen(navController: NavController?= null){

    val restaurantesXCategorias = categoriasRestaurante(restaurant)

    Column {
        TopBar()

    LazyColumn { restaurantesXCategorias.forEach{(categoria, restaurants) ->
        item {
            Text(
                text = categoria,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(20.dp)
            )
        }
        item {
            LazyRow (
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ){
                items(restaurants.distinctBy { it.id }) {restaurante ->
                    RestaurantCard(restaurant = restaurante) {
                        navController?.navigate("menu/${restaurante.id}")
                    }
                }
            }
        }
    }
    }}
}
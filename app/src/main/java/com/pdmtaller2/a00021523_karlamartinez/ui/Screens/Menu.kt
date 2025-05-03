package com.pdmtaller2.a00021523_karlamartinez.ui.Screens

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.pdmtaller2.a00021523_karlamartinez.Data.restaurant
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.pdmtaller2.a00021523_karlamartinez.Components.dishCard
import androidx.compose.foundation.lazy.items


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun menuScreen(navController: NavController, restaurantId: Int){
    val context = LocalContext.current
    val restaurante = restaurant.find { it.id == restaurantId } ?: return
    var searchQuery by remember { mutableStateOf("") }

    val filteredMenu = restaurante.menu.filter {
        it.name.contains(searchQuery, ignoreCase = true)
    }

    Column {
        TopAppBar(
            title = { Text(restaurante.name)},
            navigationIcon = {
                IconButton(onClick = {navController.popBackStack()}) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Volver atrás"
                    )
                }
            }
        )
        Text(
            text = restaurante.descripcion,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(16.dp)
        )

        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Buscar platillo") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        LazyColumn (modifier = Modifier.padding(horizontal = .16.dp)) {
            items(filteredMenu) { dish ->
                dishCard(dish = dish) {
                    Toast.makeText(context, "${dish.name} agregado al carrito", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}
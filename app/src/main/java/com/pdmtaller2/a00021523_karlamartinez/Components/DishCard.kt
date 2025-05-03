package com.pdmtaller2.a00021523_karlamartinez.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.pdmtaller2.a00021523_karlamartinez.Data.Dish

@Composable
fun dishCard(dish: Dish, onAgregarAlCarrito: () -> Unit){

    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(12.dp)
    ){ Row (
        modifier = Modifier.padding(12.dp)){
        dish.imagen?.let { imageRes ->
            Image(painter = painterResource(id = imageRes),
                contentDescription = dish.name,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.width(12.dp))

        Column (
            modifier = Modifier.weight(1f)
            ){
            Text(
                dish.name,
                style = MaterialTheme.typography.titleMedium
                )
            Text(
                dish.descripcion,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(vertical = 10.dp)
            )
        }
        IconButton(onClick = onAgregarAlCarrito, modifier = Modifier.padding(vertical = 12.dp)
        ) {
            Icon(Icons.Default.ShoppingCart, contentDescription = "Agregar al carrito")
        }
    }
    }

}
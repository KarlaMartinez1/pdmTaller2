package com.pdmtaller2.a00021523_karlamartinez.ui.Screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pdmtaller2.a00021523_karlamartinez.Components.TopBar

@Composable
fun OrdersScreen() {
    Scaffold (
        topBar = { TopBar() }
    ) { innerPadding ->
        Text(
            "Pantalla de ordenes",
            modifier = Modifier.padding(innerPadding).padding(16.dp)
        )
    }
}
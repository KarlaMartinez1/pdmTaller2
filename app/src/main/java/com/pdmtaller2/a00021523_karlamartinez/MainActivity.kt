package com.pdmtaller2.a00021523_karlamartinez

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.pdmtaller2.a00021523_karlamartinez.Navigation.Navegacion
import com.pdmtaller2.a00021523_karlamartinez.ui.theme._00021523_KarlaMartinezTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _00021523_KarlaMartinezTheme {
                Navegacion()
            }
        }
    }
}


package com.example.orderup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.orderup.dummy.menu
import com.example.orderup.screens.MenuLista
import com.example.orderup.ui.theme.OrderUpTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OrderUpTheme {
                   MenuApp()
            }
        }
    }
}

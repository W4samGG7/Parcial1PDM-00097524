package com.example.orderup.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.orderup.componentes.OrderScaffold

@Composable
fun ordenScren (navigateToMenu: () -> Unit) {
    OrderScaffold(
        titulo = "OrderUp!"
    ) { padding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(padding)
        ) {
            Text(
                text = "COMPRA PLACEHOLDER"
            )

            Button(
                modifier = Modifier.fillMaxWidth()
                    .weight(1f),
                onClick = { navigateToMenu() }
            ) {
                Text(
                    text = "Iniciar nueva orden"
                )
            }
        }
    }
}

package com.example.orderup.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import com.example.orderup.componentes.CardProduct
import com.example.orderup.componentes.OrderScaffold
import com.example.orderup.dummy.menu


@Composable
fun MenuLista(
    navigateToOrden: () -> Unit
) {
    val cantidadTotal = rememberSaveable { mutableIntStateOf(0) }

    OrderScaffold(
        titulo = "OrderUp!"
    ) { padding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(padding)
        ) {

            LazyColumn(modifier = Modifier.weight(3f)) {
                items(menu) { producto ->
                    val contador = rememberSaveable { mutableIntStateOf(0) }
                    val url = producto.imagenUrl
                    val nombre = producto.nombre
                    val precio = producto.precio.toString()
                    CardProduct(
                        url,
                        nombre,
                        precio,
                        contador,
                        itemsAgregados = { cantidadTotal.value += 1 })
                }


            }


            Button(
                modifier = Modifier.fillMaxWidth()
                    .weight(1f),
                onClick = { navigateToOrden() }
            ) {
                Text(
                    text = "Ver mi orden | Productos actuales:${cantidadTotal.value} "
                )
            }
        }
    }
}

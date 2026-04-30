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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import com.example.orderup.componentes.CardDetalle
import com.example.orderup.componentes.OrderScaffold
import com.example.orderup.model.Producto

@Composable
fun ordenScren (productos: List<Producto>,
                navigateToMenu: () -> Unit) {
    OrderScaffold(
        titulo = "OrderUp!"
    ) { padding ->
        val productosSeleccionados = rememberSaveable {productos.toMutableStateList() }

        val productosFiltrados= productosSeleccionados.groupingBy { it }.eachCount()
        val precioTotal = productosSeleccionados.sumOf { it.precio }

        Column(
            modifier = Modifier.fillMaxSize().padding(padding)
        ) {

            LazyColumn(modifier = Modifier.weight(3f)) {
                items(productosFiltrados.toList()) { (producto, cantidad) ->
                    val productoActual = producto
                    val cantidad = cantidad
                    CardDetalle(
                        producto,
                        cantidad,
                        eliminarProducto = {
                            productosSeleccionados.remove(producto)
                        }
                    )
                }
            }
            Text(
                modifier = Modifier.weight(1f),
                text = "Total: $ ${precioTotal}"
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

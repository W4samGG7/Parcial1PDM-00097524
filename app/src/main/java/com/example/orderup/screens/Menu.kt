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
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import com.example.orderup.componentes.CardProduct
import com.example.orderup.componentes.OrderScaffold
import com.example.orderup.dummy.menu
import com.example.orderup.model.Producto


@Composable
fun MenuLista(
    navigateToOrden: (List<Producto>) -> Unit
) {
    val productoSeleccionados = rememberSaveable {mutableStateListOf<Producto>() }
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
                        itemsAgregados = { productoSeleccionados.add(producto)})
                }


            }


            Button(
                modifier = Modifier.fillMaxWidth()
                    .weight(1f),
                onClick = { navigateToOrden(productoSeleccionados) }
            ) {
                Text(
                    text = "Ver mi orden | Productos actuales:${productoSeleccionados.size} "
                )
            }
        }
    }
}

package com.example.orderup.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.unit.dp
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
        titulo = "OrderUp!-Menu"
    ) { padding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(padding)
        ) {

            LazyColumn(modifier = Modifier.weight(3f)) {
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth().weight(1f),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(text = "Imagen", modifier = Modifier.weight(1.5f).padding(start = 30.dp))
                        Text(text = "Nombre", modifier = Modifier.weight(1f))
                        Text(text = "Precio", modifier = Modifier.weight(1f))
                        Text(text = "Cantidad", modifier = Modifier.weight(1f))
                    }
                }
                items(menu) { producto ->
                    val contador = productoSeleccionados.count{it.id == producto.id}
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
                    ,
                onClick = { navigateToOrden(productoSeleccionados) }
            ) {
                Text(
                    text = "Ver mi orden | Productos actuales:${productoSeleccionados.size} "
                )
            }
        }
    }
    productoSeleccionados.clear()
}

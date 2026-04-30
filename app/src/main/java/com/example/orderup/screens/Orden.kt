package com.example.orderup.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.orderup.componentes.CardDetalle
import com.example.orderup.componentes.OrderScaffold
import com.example.orderup.model.Producto
import kotlinx.coroutines.launch

@Composable
fun ordenScren (productos: List<Producto>,
                navigateToMenu: () -> Unit) {
    val snackbarHostState = remember{ SnackbarHostState() }
    val scope = rememberCoroutineScope()
    var estaConfirmada by rememberSaveable { mutableStateOf(false) }

    OrderScaffold(
        titulo = "OrderUp!-Confirmar Orden",
        snackbarHostState = snackbarHostState,
    ) { padding ->
        val productosSeleccionados = rememberSaveable {productos.toMutableStateList() }
        val productosFiltrados= productosSeleccionados.groupingBy { it }.eachCount()
        val precioTotal = productosSeleccionados.sumOf { it.precio }

        Column(
            modifier = Modifier.fillMaxSize().padding(padding)
        ) {
            LazyColumn(modifier = Modifier.weight(6f)) {
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth().weight(1f),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Nombre", modifier = Modifier.weight(1f).padding(10.dp))
                        Text(text = "Precio Unitario", modifier = Modifier.weight(1f))
                        Text(text = "Cantidad", modifier = Modifier.weight(1f))
                        Text(text = "Subtotal", modifier = Modifier.weight(1f))
                    }
                }
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
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    modifier = Modifier.fillMaxWidth()
                        .weight(1f),
                    enabled = estaConfirmada,
                    onClick = { navigateToMenu() }
                ) {
                    Text(
                        text = "Iniciar nueva orden"
                    )
                }
                Button(
                    modifier = Modifier.fillMaxWidth()
                        .weight(1f),
                    enabled = !estaConfirmada ,
                    onClick = {  scope.launch {
                        estaConfirmada = true
                        productosSeleccionados.clear()
                        snackbarHostState.showSnackbar("La orden fue completada!")
                    }}
                ) {
                    Text(
                        text = "Confirmar Orden"
                    )
                }
            }
        }
    }
}

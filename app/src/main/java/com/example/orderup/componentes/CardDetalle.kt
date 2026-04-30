package com.example.orderup.componentes


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.orderup.model.Producto

@Composable
fun CardDetalle(
    productoFinal: Producto,
    cantidad: Int,
    eliminarProducto:() -> Unit
){
    Card(
        modifier = Modifier.fillMaxWidth().clickable(onClick = {
            eliminarProducto()
        }),
    ) {
        Row(
            modifier = Modifier.padding(20.dp).fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = productoFinal.nombre
            )
            Text(
                modifier = Modifier.weight(1f),
                text = "$${productoFinal.precio}"
                )
            Text(
                modifier = Modifier.weight(1f),
                text = cantidad.toString(),
            )
            val subtotal = productoFinal.precio * cantidad
            Text(
                modifier = Modifier.weight(1f),
                text = "$${subtotal}"
            )
        }
    }
}


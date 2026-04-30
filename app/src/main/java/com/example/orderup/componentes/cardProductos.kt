package com.example.orderup.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.orderup.dummy.menu
import com.example.orderup.model.Producto
import com.example.orderup.model.TipoProducto

@Composable
fun CardProduct(
    imagen: String,
    nombre: String,
    precio: String,
    contador: MutableIntState,
    itemsAgregados: () -> Unit
){
    Card(
    modifier = Modifier.fillMaxWidth().clickable(onClick = {
        contador.value += 1
        itemsAgregados()
    }),
    ) {
        Row(
            modifier = Modifier.padding(20.dp).fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            AsyncImage(
                modifier = Modifier.size(50.dp ),
                model = imagen,
                contentDescription = "imagen del producto mostrado"
            )
            Text(
                text = nombre
            )
            Text(
                text = precio,

            )
            Text(
                text = "${contador.value}",
            )
        }
    }
}


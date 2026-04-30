package com.example.orderup.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.orderup.componentes.CardProduct
import com.example.orderup.dummy.menu
import com.example.orderup.model.Producto


@Composable
fun MenuLista(
    navigateToComprar: () -> Unit
){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {

            LazyColumn(modifier = Modifier.weight(3f)) {
                items(menu) { producto ->
                    val contador = rememberSaveable { mutableIntStateOf(0) }
                    val url = producto.imagenUrl
                    val nombre = producto.nombre
                    val precio = producto.precio.toString()
                    CardProduct(url, nombre, precio, contador)
                }


            }


        Button(
            modifier = Modifier.fillMaxWidth()
                .weight(1f),
            onClick = { navigateToComprar }
        ) {
            Text(
                text ="Comprar"
            )}
        }
    }

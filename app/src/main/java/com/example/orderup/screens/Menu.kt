package com.example.orderup.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.orderup.componentes.CardProduct
import com.example.orderup.model.Producto

@Composable
fun MenuLista(
    productos: List<Producto>
){
    LazyColumn () {
        items(productos) {
            producto ->

            val url = producto.imagenUrl
            val nombre = producto.nombre
            val precio = producto.precio.toString()
            CardProduct(url,nombre,precio)
        }
    }
}
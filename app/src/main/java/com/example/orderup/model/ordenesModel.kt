package com.example.orderup.model

import kotlinx.serialization.Serializable

@Serializable
data class Producto(
    val id: Int,
    val nombre: String,
    val precio: Double,
    val imagenUrl: String,
    val tipo: TipoProducto
)
@Serializable
enum class TipoProducto {
    PUPUSA,
    BEBIDA
}
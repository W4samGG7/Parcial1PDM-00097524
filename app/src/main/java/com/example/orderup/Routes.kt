package com.example.orderup

import androidx.navigation3.runtime.NavKey
import com.example.orderup.model.Producto
import kotlinx.serialization.Serializable

sealed class Routes : NavKey {
    @Serializable
    data object Menu : Routes()

    @Serializable
    data class Orden(val productosSeleccionado: List<Producto>) : Routes()
}
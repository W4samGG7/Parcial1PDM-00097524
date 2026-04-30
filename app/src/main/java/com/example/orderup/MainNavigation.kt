package com.example.orderup



import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.orderup.dummy.menu
import com.example.orderup.screens.MenuLista
import com.example.orderup.screens.ordenScren

@Composable
fun MenuApp() {
    val backStack = rememberNavBackStack(Routes.Menu)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Routes.Menu> { key ->
                MenuLista(
                    navigateToOrden = {
                        backStack.add(Routes.Orden)
                    }
                )
            }
            entry<Routes.Orden> { key ->
                ordenScren(
                    navigateToMenu = {
                        backStack.removeLastOrNull()
                    }
                )

            }

        }
    )
}
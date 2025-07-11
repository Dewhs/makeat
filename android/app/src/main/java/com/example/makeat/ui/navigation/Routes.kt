package com.example.makeat.ui.navigation

import kotlinx.serialization.Serializable

sealed class Routes {
    @Serializable
    data object Login : Routes()

    @Serializable
    data object Recipes : Routes()

    @Serializable
    data object Plan : Routes()

    @Serializable
    data object Stock : Routes()

    @Serializable
    data object Profile : Routes()
}
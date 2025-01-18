package com.ramki.movie.presentation.navigation

import kotlinx.serialization.Serializable

sealed interface AppDestination {

    @Serializable
    data object Splash : AppDestination

    @Serializable
    data object Home : AppDestination
}

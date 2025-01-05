package com.ramki.movie

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Movie-KMP",
    ) {
        App()
    }
}
package com.ramki.movie

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.ramki.movie.di.appModule
import org.koin.core.context.startKoin

fun main() = application {
    startKoin {
        modules(appModule)
    }
    Window(
        onCloseRequest = ::exitApplication,
        title = "Movie-KMP",
    ) {
        App()
    }
}

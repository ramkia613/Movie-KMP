package com.ramki.movie

import androidx.compose.ui.window.ComposeUIViewController
import com.ramki.movie.di.appModule
import org.koin.core.context.startKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        startKoin {
            modules(appModule)
        }
    }
) { App() }

package com.ramki.movie

import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import com.ramki.movie.di.appModule
import com.ramki.movie.util.LocalWindowSizeClass
import kotlinx.browser.document
import org.koin.core.context.startKoin

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3WindowSizeClassApi::class)
fun main() {
    startKoin {
        modules(appModule)
    }
    ComposeViewport(document.body!!) {
        val windowSizeClass = calculateWindowSizeClass()
        CompositionLocalProvider(
            LocalWindowSizeClass provides windowSizeClass
        ) {
            App()
        }
    }
}

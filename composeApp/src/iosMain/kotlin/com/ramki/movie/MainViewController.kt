package com.ramki.movie

import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.window.ComposeUIViewController
import com.ramki.movie.di.appModule
import com.ramki.movie.util.LocalWindowSizeClass
import org.koin.core.context.startKoin

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
fun MainViewController() = ComposeUIViewController(
    configure = {
        startKoin {
            modules(appModule)
        }
    }
) {
    val windowSizeClass = calculateWindowSizeClass()
    CompositionLocalProvider(
        LocalWindowSizeClass provides windowSizeClass
    ) {
        App()
    }
}

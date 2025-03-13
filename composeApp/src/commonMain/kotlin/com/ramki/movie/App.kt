package com.ramki.movie

import androidx.compose.runtime.Composable
import com.ramki.movie.presentation.navigation.AppNavGraph
import com.ramki.movie.presentation.theme.AppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    AppTheme {
        AppNavGraph()
    }
}
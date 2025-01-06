package com.ramki.movie.presentation.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Spacing(
    val spacingTiny: Dp = 1.dp,
    val spacing3XSmall: Dp = 2.dp,
    val spacing2XSmall: Dp = 4.dp,
    val spacingXSmall: Dp = 8.dp,
    val spacingSmall: Dp = 12.dp,
    val spacingMedium: Dp = 16.dp,
    val spacingLarge: Dp = 20.dp,
    val spacingXLarge: Dp = 24.dp,
    val spacing2XLarge: Dp = 24.dp,
    val spacing3XLarge: Dp = 32.dp,
)

val LocalSpacing = compositionLocalOf { Spacing() }

val MaterialTheme.spacing: Spacing
    @Composable
    @ReadOnlyComposable
    get() = LocalSpacing.current

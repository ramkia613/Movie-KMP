package com.ramki.movie.presentation.screens.splash

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SplashScreen(
    onSplashFinished: () -> Unit
) {
    LaunchedEffect(true) {
        CoroutineScope(Dispatchers.Main).launch {
            delay(2000)
            onSplashFinished()
        }
    }

    SplashDetails()
}


@Composable
private fun SplashDetails() {

    var isAnimating by remember { mutableStateOf(false) }

    val textSize by animateFloatAsState(
        targetValue = if (isAnimating) 80f else 30f,
        animationSpec = tween(durationMillis = 1000, easing = LinearEasing)
    )

    val gradientBrush = Brush.linearGradient(
        colors = listOf(Color(0xFF6A1B9A), Color(0xFF4CAF50))
    )

    val rotationAngle by animateFloatAsState(
        targetValue = if (isAnimating) 360f else 0f,
        animationSpec = tween(durationMillis = 1000, easing = LinearEasing)
    )

    LaunchedEffect(Unit) {
        isAnimating = true
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Movies",
            modifier = Modifier
                .graphicsLayer(rotationZ = rotationAngle)
                .padding(8.dp),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = textSize.sp,
                brush = gradientBrush
            )
        )
    }
}

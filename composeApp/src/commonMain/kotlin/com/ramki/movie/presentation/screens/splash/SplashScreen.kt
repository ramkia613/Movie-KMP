package com.ramki.movie.presentation.screens.splash

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import movie_kmp.composeapp.generated.resources.Res
import movie_kmp.composeapp.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.painterResource

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
private fun SplashDetails(modifier: Modifier = Modifier) {
    AnimatedVisibility(true) {
        Column(modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painterResource(Res.drawable.compose_multiplatform), null)
        }
    }
}

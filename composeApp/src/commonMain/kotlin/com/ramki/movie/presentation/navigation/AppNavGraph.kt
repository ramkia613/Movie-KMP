package com.ramki.movie.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ramki.movie.presentation.navigation.AppDestination.Splash
import com.ramki.movie.presentation.screens.home.HomeScreen
import com.ramki.movie.presentation.screens.splash.SplashScreen

@Composable
fun AppNavGraph(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Splash
    ) {

        composable<Splash> {
            SplashScreen(
                onSplashFinished = {
                    navController.navigate(AppDestination.Home) {
                        popUpTo(Splash) {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable<AppDestination.Home> {
            HomeScreen()
        }
    }
}

package com.jppedrosa.moovies.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jppedrosa.moovies.presentation.screens.details.DetailsScreen
import com.jppedrosa.moovies.presentation.screens.home.HomeScreen

/**
 * @author João Pedro Pedrosa (<a href="mailto:joaopopedrosa@gmail.com">joaopopedrosa@gmail.com</a>) on 22/09/2022.
 */

@Composable
fun MooviesNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ) {
        composable(Screen.HomeScreen.route) {
            HomeScreen(navController = navController)
        }
        composable(Screen.DetailsScreen.route) {
            DetailsScreen(navController = navController)
        }
    }
}
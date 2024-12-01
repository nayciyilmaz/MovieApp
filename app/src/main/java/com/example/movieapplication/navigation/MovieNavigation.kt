package com.example.movieapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieapplication.screens.DetailScreen
import com.example.movieapplication.screens.HomeScreen

@Composable
fun MovieNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = MovieScreen.HomeScreen.route) {

        composable(route = MovieScreen.HomeScreen.route) {
            HomeScreen(navController = navController)
        }
        composable(route = "${MovieScreen.DetailsScreen.route}/{movieId}",
            arguments = listOf(navArgument("movieId") { type = NavType.IntType }
            )) { backStackEntry ->
            run {
                val movieId = backStackEntry.arguments?.getInt("movieId")
                DetailScreen(navController = navController, movieId = movieId)
            }
        }
    }
}
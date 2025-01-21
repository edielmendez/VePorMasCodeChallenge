package mx.com.edieltech.vepormascodechallenge.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mx.com.edieltech.vepormascodechallenge.presentation.navigation.routes.HomeRoute
import mx.com.edieltech.vepormascodechallenge.presentation.screens.home.HomeScreen

@Composable
fun VePorMasCodeChallengeNavHost(
    startDestination: HomeRoute = HomeRoute
){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startDestination
    ){
        composable<HomeRoute> { backStackEntry ->
            HomeScreen()
        }
    }
}
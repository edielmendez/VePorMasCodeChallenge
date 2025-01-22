package mx.com.edieltech.vepormascodechallenge.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import mx.com.edieltech.vepormascodechallenge.presentation.navigation.routes.DetailRoute
import mx.com.edieltech.vepormascodechallenge.presentation.navigation.routes.HomeRoute
import mx.com.edieltech.vepormascodechallenge.presentation.screens.detail.DetailScreen
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
            HomeScreen(
                 navigateToDetailScreen = { title, image ->
                     navController.navigate(DetailRoute(title = title, image = image))
                 }
            )
        }
        composable<DetailRoute> { backStackEntry ->
            val detailRoute: DetailRoute = backStackEntry.toRoute()
            DetailScreen(
                title = detailRoute.title,
                image = detailRoute.image,
                onButtonBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
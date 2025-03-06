package com.gonzapolleria.kmp2025.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.gonzapolleria.kmp2025.example_ktor_coil.ScreenPrueba
import com.gonzapolleria.kmp2025.example_room.domain.entities.MovieDom
import com.gonzapolleria.kmp2025.example_room.ui.MovieScreen
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun NavigationWrapper() {
    val mainNavController = rememberNavController()

    NavHost(navController = mainNavController, startDestination = Routes.Home.route) {
        composable(route = Routes.Home.route) {
            MovieScreen(
                viewModel = koinViewModel(),
                mainNavController
            )
        }

        composable<MovieDetail> { navBackStackEntry ->
            val characterDetailEncoding: MovieDetail =
                navBackStackEntry.toRoute<MovieDetail>()

            val movieDom: MovieDom =
                Json.decodeFromString<MovieDom>(characterDetailEncoding.movieDetail)

            ScreenPrueba(
                movieDom = movieDom,
                onBackPressed = { mainNavController.popBackStack() })
        }
    }

}
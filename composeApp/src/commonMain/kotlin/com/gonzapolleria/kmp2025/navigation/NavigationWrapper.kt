package com.gonzapolleria.kmp2025.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.gonzapolleria.kmp2025.example_ktor_coil.ScreenPrueba
import com.gonzapolleria.kmp2025.example_room.domain.entities.MovieDom
import com.gonzapolleria.kmp2025.example_room.ui.MovieScreen
import com.gonzapolleria.kmp2025.login.ui.LoginScreen
import com.gonzapolleria.kmp2025.onboarding.OnboardingScreen
import com.gonzapolleria.kmp2025.onboarding.OnboardingUtils
import kotlinx.serialization.json.Json
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun NavigationWrapper() {
    val mainNavController = rememberNavController()
    val initialRoute = if (OnboardingUtils.isOnboardingCompleted()) Routes.Login.route else Routes.Onboarding.route

    NavHost(navController = mainNavController, startDestination = initialRoute) {

        composable(route = Routes.Onboarding.route) {
            OnboardingScreen {
                OnboardingUtils.setOnboardingCompleted()
                mainNavController.navigate(Routes.Home.route){
                    popUpTo(Routes.Onboarding.route) {
                        inclusive = true
                    }
                }
            }
        }

        composable(route = Routes.Home.route) {
            MovieScreen(
                viewModel = koinViewModel(),
                mainNavController
            )
        }

        composable(route = Routes.Login.route) {
            LoginScreen()
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
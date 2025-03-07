package com.gonzapolleria.kmp2025.navigation

import kotlinx.serialization.Serializable


sealed class Routes(val route:String){
    data object Onboarding: Routes(route = "onboarding")
    data object Home: Routes(route = "prueba_room")
}

@Serializable
data class MovieDetail(val movieDetail: String)
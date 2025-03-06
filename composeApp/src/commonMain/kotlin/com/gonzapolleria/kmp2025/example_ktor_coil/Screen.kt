package com.gonzapolleria.kmp2025.example_ktor_coil

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.gonzapolleria.kmp2025.example_room.domain.entities.MovieDom

@Composable
fun ScreenPrueba(movieDom: MovieDom, onBackPressed: () -> Boolean) {
    Box(Modifier.fillMaxSize().background(Color.Blue)){
        Text("Holaa ${movieDom.name}")
    }
}
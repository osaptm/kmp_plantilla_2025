package com.gonzapolleria.roomexample

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import com.gonzapolleria.roomexample.infrastructure.Movies.MovieScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        MovieScreen()
    }
}
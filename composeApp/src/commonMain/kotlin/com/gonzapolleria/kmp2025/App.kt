package com.gonzapolleria.kmp2025

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import com.gonzapolleria.kmp2025.example_room.ui.MovieScreen
import com.gonzapolleria.kmp2025.navigation.NavigationWrapper
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        NavigationWrapper()
    }
}
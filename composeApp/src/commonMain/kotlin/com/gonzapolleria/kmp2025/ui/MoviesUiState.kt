package com.gonzapolleria.kmp2025.ui

import androidx.compose.ui.text.input.TextFieldValue
import com.gonzapolleria.kmp2025.data.database.entities.MovieEntity

data class MovieUiState(
    val movieName: TextFieldValue = TextFieldValue(""),
    val movies: List<MovieEntity> = emptyList()
)

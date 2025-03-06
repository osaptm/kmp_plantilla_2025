package com.gonzapolleria.kmp2025.example_room.ui

import androidx.compose.ui.text.input.TextFieldValue
import com.gonzapolleria.kmp2025.example_room.domain.entities.MovieDom

data class MovieUiState(
    val movieName: TextFieldValue = TextFieldValue(""),
    val movies: List<MovieDom> = emptyList()
)

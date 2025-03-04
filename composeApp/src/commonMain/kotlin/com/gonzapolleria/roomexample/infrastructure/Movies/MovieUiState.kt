package com.gonzapolleria.roomexample.infrastructure.Movies

import androidx.compose.ui.text.input.TextFieldValue
import com.gonzapolleria.roomexample.application.database.entities.MovieEntity

data class MovieUiState(
    val movieName: TextFieldValue = TextFieldValue(""),
    val movies: List<MovieEntity> = emptyList()
)

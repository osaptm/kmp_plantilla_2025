package com.gonzapolleria.roomexample.ui.movies

import androidx.compose.ui.text.input.TextFieldValue
import com.gonzapolleria.roomexample.data.database.entities.MovieEntity

data class MovieUiState(
    val movieName: TextFieldValue = TextFieldValue(""),
    val movies: List<MovieEntity> = emptyList()
)

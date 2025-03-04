package com.gonzapolleria.roomexample.infrastructure.Movies

import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gonzapolleria.roomexample.application.database.dao.MovieDao
import com.gonzapolleria.roomexample.application.database.entities.MovieEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MovieViewModel(private val movieDao: MovieDao): ViewModel() {

    private val _movieName = MutableStateFlow(TextFieldValue(""))

        val uiState: StateFlow<MovieUiState> = combine(
            movieDao.getMovies(),
            _movieName
        ) { movies, movieText ->
            MovieUiState(movieName = movieText, movies = movies)
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = MovieUiState()
        )



    fun updateMovieName(newText: TextFieldValue) {
        _movieName.value = newText
    }

    fun insertMovie(movieName: String) {
        viewModelScope.launch {
            movieDao.insert(MovieEntity(name = movieName))
        }
    }

    fun deleteMovies() {
        viewModelScope.launch {
            movieDao.deleteMovies()
        }
    }
}
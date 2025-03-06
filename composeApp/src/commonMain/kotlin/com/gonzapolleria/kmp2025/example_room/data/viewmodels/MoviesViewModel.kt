package com.gonzapolleria.kmp2025.example_room.data.viewmodels

import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gonzapolleria.kmp2025.example_room.domain.entities.MovieDom
import com.gonzapolleria.kmp2025.example_room.domain.usecases.AddMovieUseCase
import com.gonzapolleria.kmp2025.example_room.domain.usecases.DeleteAllMoviesUseCase
import com.gonzapolleria.kmp2025.example_room.domain.usecases.GetAllMoviesUseCase
import com.gonzapolleria.kmp2025.example_room.ui.MovieUiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MovieViewModel(
    private val addMovieUseCase: AddMovieUseCase,
    getAllMoviesUseCase: GetAllMoviesUseCase,
    private val deleteAllMoviesUseCase: DeleteAllMoviesUseCase
) : ViewModel() {

    // Obtener el flujo de todas las películas
    private val moviesFlow: Flow<List<MovieDom>> = getAllMoviesUseCase()

    // Obtener el flujo del nombre de la película
    private val movieNameFlow: MutableStateFlow<TextFieldValue> = MutableStateFlow(TextFieldValue(""))

    // Combinar los dos flujos
    private val combinedFlow: Flow<MovieUiState> = combine(moviesFlow, movieNameFlow) { movies, movieText ->
        // Crear un nuevo estado de UI con los valores combinados
        MovieUiState(movieName = movieText, movies)
    }
    // Convertir el flujo combinado en un StateFlow
    val uiState: StateFlow<MovieUiState> = combinedFlow.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = MovieUiState()
    )


    fun updateMovieName(newText: TextFieldValue) {
        movieNameFlow.value = newText
    }

    fun insertMovie(movieName: String) {
        viewModelScope.launch {
            addMovieUseCase(MovieDom(name = movieName, id = 0L))
        }
    }

    fun deleteMovies() {
        viewModelScope.launch {
            deleteAllMoviesUseCase()
        }
    }
}
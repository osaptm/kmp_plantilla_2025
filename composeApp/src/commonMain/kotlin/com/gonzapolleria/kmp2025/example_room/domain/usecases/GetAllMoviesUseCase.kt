package com.gonzapolleria.kmp2025.example_room.domain.usecases

import com.gonzapolleria.kmp2025.example_room.domain.entities.MovieDom
import com.gonzapolleria.kmp2025.example_room.domain.repositories.MovieRepository
import kotlinx.coroutines.flow.Flow

class GetAllMoviesUseCase(private val repository: MovieRepository) {
    operator fun invoke(): Flow<List<MovieDom>> {
        return repository.getAllMovies()
    }
}
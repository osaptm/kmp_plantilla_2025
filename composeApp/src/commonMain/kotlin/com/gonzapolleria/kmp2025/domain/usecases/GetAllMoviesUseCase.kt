package com.gonzapolleria.kmp2025.domain.usecases

import com.gonzapolleria.kmp2025.domain.entities.MovieDom
import com.gonzapolleria.kmp2025.domain.repositories.MovieRepository
import kotlinx.coroutines.flow.Flow

class GetAllMoviesUseCase(private val repository: MovieRepository) {
    operator fun invoke(): Flow<List<MovieDom>> {
        return repository.getAllMovies()
    }
}
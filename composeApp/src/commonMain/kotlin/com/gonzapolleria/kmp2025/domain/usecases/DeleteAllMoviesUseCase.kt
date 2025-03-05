package com.gonzapolleria.kmp2025.domain.usecases

import com.gonzapolleria.kmp2025.domain.repositories.MovieRepository

class DeleteAllMoviesUseCase(private val repository: MovieRepository) {
    suspend operator fun invoke() {
        repository.deleteAllMovies()
    }
}
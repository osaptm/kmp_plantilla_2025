package com.gonzapolleria.kmp2025.example_room.domain.usecases

import com.gonzapolleria.kmp2025.example_room.domain.repositories.MovieRepository

class DeleteAllMoviesUseCase(private val repository: MovieRepository) {
    suspend operator fun invoke() {
        repository.deleteAllMovies()
    }
}
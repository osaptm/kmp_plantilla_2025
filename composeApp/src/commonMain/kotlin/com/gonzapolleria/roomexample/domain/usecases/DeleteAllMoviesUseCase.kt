package com.gonzapolleria.roomexample.domain.usecases

import com.gonzapolleria.roomexample.domain.repositories.MovieRepository

class DeleteAllMoviesUseCase(private val repository: MovieRepository) {
    suspend operator fun invoke() {
        repository.deleteAllMovies()
    }
}
package com.gonzapolleria.roomexample.domain.usecases

import com.gonzapolleria.roomexample.domain.entities.MovieDom
import com.gonzapolleria.roomexample.domain.repositories.MovieRepository
import kotlinx.coroutines.flow.Flow

class GetAllMoviesUseCase(private val repository: MovieRepository) {
    operator fun invoke(): Flow<List<MovieDom>> {
        return repository.getAllMovies()
    }
}
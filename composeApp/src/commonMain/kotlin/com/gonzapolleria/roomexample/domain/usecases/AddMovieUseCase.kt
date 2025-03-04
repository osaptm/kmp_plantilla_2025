package com.gonzapolleria.roomexample.domain.usecases

import com.gonzapolleria.roomexample.domain.entities.MovieDom
import com.gonzapolleria.roomexample.domain.repositories.MovieRepository

class AddMovieUseCase(private val repository: MovieRepository) {
    suspend operator fun invoke(movie: MovieDom) {
        repository.addMovie(movie)
    }
}
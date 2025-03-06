package com.gonzapolleria.kmp2025.example_room.domain.usecases

import com.gonzapolleria.kmp2025.example_room.domain.entities.MovieDom
import com.gonzapolleria.kmp2025.example_room.domain.repositories.MovieRepository

class AddMovieUseCase(private val repository: MovieRepository) {
    suspend operator fun invoke(movie: MovieDom) {
        repository.addMovie(movie)
    }
}
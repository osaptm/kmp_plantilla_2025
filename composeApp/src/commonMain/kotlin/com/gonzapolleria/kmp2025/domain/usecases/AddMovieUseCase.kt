package com.gonzapolleria.kmp2025.domain.usecases

import com.gonzapolleria.kmp2025.domain.entities.MovieDom
import com.gonzapolleria.kmp2025.domain.repositories.MovieRepository

class AddMovieUseCase(private val repository: MovieRepository) {
    suspend operator fun invoke(movie: MovieDom) {
        repository.addMovie(movie)
    }
}
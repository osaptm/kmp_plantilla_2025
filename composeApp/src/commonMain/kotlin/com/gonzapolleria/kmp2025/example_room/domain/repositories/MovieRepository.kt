package com.gonzapolleria.kmp2025.example_room.domain.repositories

import com.gonzapolleria.kmp2025.example_room.domain.entities.MovieDom
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun addMovie(movie: MovieDom)
    fun getAllMovies(): Flow<List<MovieDom>>
    suspend fun deleteAllMovies()
}
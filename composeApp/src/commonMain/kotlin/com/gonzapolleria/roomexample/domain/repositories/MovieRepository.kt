package com.gonzapolleria.roomexample.domain.repositories

import com.gonzapolleria.roomexample.domain.entities.MovieDom
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun addMovie(movie: MovieDom)
    fun getAllMovies(): Flow<List<MovieDom>>
    suspend fun deleteAllMovies()
}
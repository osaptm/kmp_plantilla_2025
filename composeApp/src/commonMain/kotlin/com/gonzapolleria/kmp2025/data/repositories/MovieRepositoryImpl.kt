package com.gonzapolleria.kmp2025.data.repositories

import com.gonzapolleria.kmp2025.data.database.dao.MovieDao
import com.gonzapolleria.kmp2025.data.mappers.toEntity
import com.gonzapolleria.kmp2025.data.mappers.toDomain
import com.gonzapolleria.kmp2025.domain.entities.MovieDom
import com.gonzapolleria.kmp2025.domain.repositories.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MovieRepositoryImpl(private val movieDao: MovieDao) : MovieRepository {

    override suspend fun addMovie(movie: MovieDom) {
        movieDao.insert(movie.toEntity())
    }

    override fun getAllMovies(): Flow<List<MovieDom>> {
        return movieDao.getMovies().map { movieEntities ->
            movieEntities.map { it.toDomain() }
        }
    }

    override suspend fun deleteAllMovies() {
        return movieDao.deleteMovies()
    }

}



package com.gonzapolleria.kmp2025.example_room.data.repositories

import com.gonzapolleria.kmp2025.example_room.data.mappers.MovieMapper
import com.gonzapolleria.kmp2025.shared.room_database.dao.MovieDao
import com.gonzapolleria.kmp2025.example_room.domain.entities.MovieDom
import com.gonzapolleria.kmp2025.example_room.domain.repositories.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MovieRepositoryImpl(private val movieDao: MovieDao) : MovieRepository {

    override suspend fun addMovie(movie: MovieDom) {
        movieDao.insert( MovieMapper.toEntity(movie) )
    }

    override fun getAllMovies(): Flow<List<MovieDom>> {
        return movieDao.getMovies().map { movieEntities ->
            movieEntities.map { MovieMapper.toDomain(it) }
        }
    }

    override suspend fun deleteAllMovies() {
        return movieDao.deleteMovies()
    }

}



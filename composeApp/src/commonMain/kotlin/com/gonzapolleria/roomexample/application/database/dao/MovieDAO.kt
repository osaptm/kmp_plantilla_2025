package com.gonzapolleria.roomexample.application.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.gonzapolleria.roomexample.application.database.entities.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Query("SELECT * FROM movie")
    fun getMovies(): Flow<List<MovieEntity>>

    @Insert
    suspend fun insert(movie: MovieEntity)

    @Query("DELETE FROM movie")
    suspend fun deleteMovies()
}
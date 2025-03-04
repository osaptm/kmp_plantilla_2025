package com.gonzapolleria.roomexample.application.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.gonzapolleria.roomexample.application.database.dao.MovieDao
import com.gonzapolleria.roomexample.application.database.entities.MovieEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

const val DATABASE_NAME = "movie_database.db"

@Database(entities = [MovieEntity::class], version = 1)
@ConstructedBy(MovieDatabaseConstructor::class)
abstract class MovieDatabase: RoomDatabase() {
    abstract fun getMovieDao(): MovieDao
}

// Room compiler generates the `actual` implementations
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object MovieDatabaseConstructor : RoomDatabaseConstructor<MovieDatabase> {
    override fun initialize(): MovieDatabase
}

fun getMovieDatabase(builder: RoomDatabase.Builder<MovieDatabase>): MovieDatabase {
    return builder
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}
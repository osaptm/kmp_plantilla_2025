package com.gonzapolleria.roomexample.application.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

fun getDatabaseBuilder(context: Context): RoomDatabase.Builder<MovieDatabase> {
    val appContext = context.applicationContext
    val dbFile = appContext.getDatabasePath(DATABASE_NAME)

    return Room.databaseBuilder<MovieDatabase>(
        context = appContext,
        name = dbFile.absolutePath,
    )
}
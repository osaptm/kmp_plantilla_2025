package com.gonzapolleria.roomexample.application.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("movie")
data class MovieEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val name: String,
)

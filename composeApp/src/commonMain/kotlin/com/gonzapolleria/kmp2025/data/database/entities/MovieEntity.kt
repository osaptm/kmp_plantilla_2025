package com.gonzapolleria.kmp2025.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("movie")
data class MovieEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val name: String,
)

package com.gonzapolleria.kmp2025.example_room.domain.entities

import kotlinx.serialization.Serializable

@Serializable
data class MovieDom(
    val id: Long,
    val name: String,
)

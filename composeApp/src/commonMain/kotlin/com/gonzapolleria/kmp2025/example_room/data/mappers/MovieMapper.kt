package com.gonzapolleria.kmp2025.example_room.data.mappers

import com.gonzapolleria.kmp2025.example_room.domain.entities.MovieDom
import com.gonzapolleria.kmp2025.shared.room.entities.MovieEntity

object MovieMapper {
    fun toDomain(entity: MovieEntity): MovieDom {
        return MovieDom(
            id = entity.id,
            name = entity.name,
        )
    }

    fun toEntity(domain: MovieDom): MovieEntity {
        return MovieEntity(
            id = domain.id,
            name = domain.name,
        )
    }
}
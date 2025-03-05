package com.gonzapolleria.kmp2025.data.mappers

import com.gonzapolleria.kmp2025.data.database.entities.MovieEntity
import com.gonzapolleria.kmp2025.domain.entities.MovieDom

fun MovieDom.toEntity(): MovieEntity {
    return MovieEntity(
        id = this.id,
        name = this.name,
    )
}
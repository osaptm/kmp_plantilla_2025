package com.gonzapolleria.roomexample.data.mappers

import com.gonzapolleria.roomexample.data.database.entities.MovieEntity
import com.gonzapolleria.roomexample.domain.entities.MovieDom

fun MovieDom.toEntity(): MovieEntity {
    return MovieEntity(
        id = this.id,
        name = this.name,
    )
}
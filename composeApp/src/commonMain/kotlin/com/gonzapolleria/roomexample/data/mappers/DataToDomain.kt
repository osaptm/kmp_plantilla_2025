package com.gonzapolleria.roomexample.data.mappers

import com.gonzapolleria.roomexample.data.database.entities.MovieEntity
import com.gonzapolleria.roomexample.domain.entities.MovieDom

fun MovieEntity.toDomain(): MovieDom {
    return MovieDom(
        id = this.id,
        name = this.name,
    )
}


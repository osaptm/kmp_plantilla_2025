package com.gonzapolleria.kmp2025.shared.di

import com.gonzapolleria.kmp2025.shared.room_database.MovieDatabase
import com.gonzapolleria.kmp2025.shared.room_database.dao.MovieDao
import org.koin.core.module.Module
import org.koin.dsl.module

fun roomModule(): Module = module {
    single<MovieDao> { get<MovieDatabase>().getMovieDao() }
}
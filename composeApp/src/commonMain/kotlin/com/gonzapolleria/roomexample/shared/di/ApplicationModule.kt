package com.gonzapolleria.roomexample.shared.di

import com.gonzapolleria.roomexample.application.database.MovieDatabase
import com.gonzapolleria.roomexample.application.database.dao.MovieDao
import org.koin.core.module.Module
import org.koin.dsl.module

fun applicationModule(): Module = module {
    single<MovieDao> { get<MovieDatabase>().getMovieDao() }
}
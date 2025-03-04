package com.gonzapolleria.roomexample.shared.di

import com.gonzapolleria.roomexample.data.database.MovieDatabase
import com.gonzapolleria.roomexample.data.database.dao.MovieDao
import com.gonzapolleria.roomexample.data.repositories.MovieRepositoryImpl
import com.gonzapolleria.roomexample.domain.repositories.MovieRepository
import com.gonzapolleria.roomexample.data.viewmodels.MovieViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

fun dataModule(): Module = module {
    single<MovieDao> { get<MovieDatabase>().getMovieDao() }
    single<MovieRepository> { MovieRepositoryImpl(get()) }
    viewModelOf(::MovieViewModel)
}
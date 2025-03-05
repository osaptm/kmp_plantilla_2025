package com.gonzapolleria.kmp2025.shared.di

import com.gonzapolleria.kmp2025.data.database.MovieDatabase
import com.gonzapolleria.kmp2025.data.database.dao.MovieDao
import com.gonzapolleria.kmp2025.data.repositories.MovieRepositoryImpl
import com.gonzapolleria.kmp2025.domain.repositories.MovieRepository
import com.gonzapolleria.kmp2025.data.viewmodels.MovieViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

fun dataModule(): Module = module {
    single<MovieDao> { get<MovieDatabase>().getMovieDao() }
    single<MovieRepository> { MovieRepositoryImpl(get()) }
    viewModelOf(::MovieViewModel)
}
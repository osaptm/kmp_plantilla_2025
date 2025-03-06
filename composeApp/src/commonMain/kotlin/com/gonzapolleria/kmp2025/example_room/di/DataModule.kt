package com.gonzapolleria.kmp2025.example_room.di

import com.gonzapolleria.kmp2025.shared.room_database.MovieDatabase
import com.gonzapolleria.kmp2025.shared.room_database.dao.MovieDao
import com.gonzapolleria.kmp2025.example_room.data.repositories.MovieRepositoryImpl
import com.gonzapolleria.kmp2025.example_room.domain.repositories.MovieRepository
import com.gonzapolleria.kmp2025.example_room.data.viewmodels.MovieViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

fun dataModule(): Module = module {
    single<MovieRepository> { MovieRepositoryImpl(get()) }
    viewModelOf(::MovieViewModel)
}
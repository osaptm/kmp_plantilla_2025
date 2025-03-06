package com.gonzapolleria.kmp2025.example_room.di

import com.gonzapolleria.kmp2025.example_room.domain.usecases.AddMovieUseCase
import com.gonzapolleria.kmp2025.example_room.domain.usecases.DeleteAllMoviesUseCase
import com.gonzapolleria.kmp2025.example_room.domain.usecases.GetAllMoviesUseCase
import org.koin.core.module.Module
import org.koin.dsl.module

fun domainModule(): Module = module {
    factory { AddMovieUseCase(get()) }
    factory { GetAllMoviesUseCase(get()) }
    factory { DeleteAllMoviesUseCase(get()) }
}
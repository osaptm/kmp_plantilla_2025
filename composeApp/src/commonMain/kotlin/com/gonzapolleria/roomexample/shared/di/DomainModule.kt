package com.gonzapolleria.roomexample.shared.di

import com.gonzapolleria.roomexample.domain.usecases.AddMovieUseCase
import com.gonzapolleria.roomexample.domain.usecases.DeleteAllMoviesUseCase
import com.gonzapolleria.roomexample.domain.usecases.GetAllMoviesUseCase
import org.koin.core.module.Module
import org.koin.dsl.module

fun domainModule(): Module = module {
    factory { AddMovieUseCase(get()) }
    factory { GetAllMoviesUseCase(get()) }
    factory { DeleteAllMoviesUseCase(get()) }
}
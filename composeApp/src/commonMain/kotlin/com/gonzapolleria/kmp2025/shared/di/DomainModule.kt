package com.gonzapolleria.kmp2025.shared.di

import com.gonzapolleria.kmp2025.domain.usecases.AddMovieUseCase
import com.gonzapolleria.kmp2025.domain.usecases.DeleteAllMoviesUseCase
import com.gonzapolleria.kmp2025.domain.usecases.GetAllMoviesUseCase
import org.koin.core.module.Module
import org.koin.dsl.module

fun domainModule(): Module = module {
    factory { AddMovieUseCase(get()) }
    factory { GetAllMoviesUseCase(get()) }
    factory { DeleteAllMoviesUseCase(get()) }
}
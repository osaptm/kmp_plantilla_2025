package com.gonzapolleria.roomexample.shared.di

import com.gonzapolleria.roomexample.infrastructure.Movies.MovieViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

fun uiModule(): Module = module {
    viewModelOf(::MovieViewModel)
}
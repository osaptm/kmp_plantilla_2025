package com.gonzapolleria.kmp2025.example_ktor_coil.di

import com.gonzapolleria.kmp2025.example_ktor_coil.ScreenViewModel
import com.gonzapolleria.kmp2025.example_ktor_coil.remote.ApiService
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val dataModule = module {
    factoryOf(::ApiService)
    viewModelOf(::ScreenViewModel)
}
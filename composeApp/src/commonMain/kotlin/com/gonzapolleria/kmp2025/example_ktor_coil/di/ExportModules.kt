package com.gonzapolleria.kmp2025.example_ktor_coil.di
import org.koin.core.module.Module

fun ktorCoilModules(): List<Module>  {
    return listOf(dataModule)
}
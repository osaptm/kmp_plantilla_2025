package com.gonzapolleria.kmp2025.example_room.di

import org.koin.core.module.Module

fun roomExampleModules(): List<Module>  {
    return listOf(dataModule(), uiModule(), domainModule())
}
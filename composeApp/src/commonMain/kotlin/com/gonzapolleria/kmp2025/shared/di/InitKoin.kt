package com.gonzapolleria.kmp2025.shared.di

import com.gonzapolleria.kmp2025.example_ktor_coil.di.ktorCoilModules
import com.gonzapolleria.kmp2025.example_room.di.roomExampleModules
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration


fun initKoin(appDeclaration: KoinAppDeclaration = {}) {
    startKoin {
        appDeclaration()
        modules(
                    sharedModule() +
                    platformModule() +
                    roomExampleModules() + ktorCoilModules()
        )
    }
}

fun initKoinIos() = initKoin(appDeclaration = {})
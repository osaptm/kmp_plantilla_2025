package com.gonzapolleria.roomexample.shared.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration


fun initKoin(appDeclaration: KoinAppDeclaration = {}) {
    startKoin {
        appDeclaration()
        modules(
            uiModule() + dataModule() + domainModule() + platformModule()
        )
    }
}

fun initKoinIos() = initKoin(appDeclaration = {})
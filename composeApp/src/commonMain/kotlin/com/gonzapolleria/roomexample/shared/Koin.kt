package com.gonzapolleria.roomexample.shared

import com.gonzapolleria.roomexample.shared.di.applicationModule
import com.gonzapolleria.roomexample.shared.di.domainModule
import com.gonzapolleria.roomexample.shared.di.platformModule
import com.gonzapolleria.roomexample.shared.di.uiModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration


fun initKoin(appDeclaration: KoinAppDeclaration = {}) {
    startKoin {
        appDeclaration()
        modules(
            uiModule() + applicationModule() + domainModule() + platformModule()
        )
    }
}

fun initKoinIos() = initKoin(appDeclaration = {})
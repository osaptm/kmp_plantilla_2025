package com.gonzapolleria.kmp2025

import android.app.Application
import com.gonzapolleria.kmp2025.shared.di.initKoin
import org.koin.android.ext.koin.androidContext

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin(
            appDeclaration = { androidContext(this@MainApplication) },
        )
    }
}
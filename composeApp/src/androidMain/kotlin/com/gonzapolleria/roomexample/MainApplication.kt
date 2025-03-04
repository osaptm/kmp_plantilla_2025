package com.gonzapolleria.roomexample

import android.app.Application
import com.gonzapolleria.roomexample.shared.initKoin
import org.koin.android.ext.koin.androidContext

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin(
            appDeclaration = { androidContext(this@MainApplication) },
        )
    }
}
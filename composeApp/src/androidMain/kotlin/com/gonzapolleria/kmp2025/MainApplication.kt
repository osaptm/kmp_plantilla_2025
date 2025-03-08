package com.gonzapolleria.kmp2025

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.gonzapolleria.kmp2025.shared.di.initKoin
import org.koin.android.ext.koin.androidContext


@SuppressLint("StaticFieldLeak")
object ApplicationContextProvider {
    lateinit var context: Context
        private set
    fun init(context: Context) {
        this.context = context
    }
}

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // Inicializar el contexto
        ApplicationContextProvider.init(this)

        // Inicia Koin
        initKoin(
            appDeclaration = { androidContext(this@MainApplication) },
        )

    }
}
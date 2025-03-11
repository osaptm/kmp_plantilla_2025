package com.gonzapolleria.kmp2025

import android.content.Context
import androidx.startup.Initializer
import com.gonzapolleria.kmp2025.shared.pushnotification.AppInitializerPush

class NotifierInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        AppInitializerPush.onApplicationStart()
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }
}
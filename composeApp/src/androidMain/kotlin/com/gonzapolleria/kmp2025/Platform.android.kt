package com.gonzapolleria.kmp2025

import android.os.Build
import android.util.Log
import com.mmk.kmpnotifier.notification.NotifierManager
import com.mmk.kmpnotifier.notification.configuration.NotificationPlatformConfiguration

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()

actual fun onApplicationStartPlatformSpecific() {
    NotifierManager.initialize(
        configuration = NotificationPlatformConfiguration.Android(
            notificationIconResId = R.drawable.ic_launcher_foreground,
        )
    )
}

actual fun logMessage(message: String) {
    Log.d("Notifications", message)
}
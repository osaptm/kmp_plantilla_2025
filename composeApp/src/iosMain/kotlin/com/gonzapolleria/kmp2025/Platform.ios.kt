package com.gonzapolleria.kmp2025

import com.mmk.kmpnotifier.notification.NotifierManager
import com.mmk.kmpnotifier.notification.configuration.NotificationPlatformConfiguration
import platform.Foundation.NSLog
import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatform(): Platform = IOSPlatform()
actual fun onApplicationStartPlatformSpecific() {
    NotifierManager.initialize(NotificationPlatformConfiguration.Ios())
}

actual fun logMessage(message: String) {
    NSLog(message)
}
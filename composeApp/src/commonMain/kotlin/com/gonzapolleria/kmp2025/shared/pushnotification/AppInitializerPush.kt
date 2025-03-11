package com.gonzapolleria.kmp2025.shared.pushnotification


import com.mmk.kmpnotifier.notification.NotifierManager
import com.mmk.kmpnotifier.notification.PayloadData
import com.gonzapolleria.kmp2025.onApplicationStartPlatformSpecific
import com.gonzapolleria.kmp2025.logMessage


object AppInitializerPush {
    fun onApplicationStart() {
        onApplicationStartPlatformSpecific()
        NotifierManager.addListener(object : NotifierManager.Listener {
            override fun onNewToken(token: String) {
                println("Push Notification onNewToken: $token")
                logMessage("Push Notification onNewToken: $token")
            }

            override fun onPayloadData(data: PayloadData) {
                super.onPayloadData(data)
                println("Push Notification payloadData: $data")
                logMessage("Push Notification payloadData: $data")
            }
        })
    }
}
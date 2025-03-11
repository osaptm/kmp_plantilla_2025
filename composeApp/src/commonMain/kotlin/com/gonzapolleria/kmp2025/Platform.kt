package com.gonzapolleria.kmp2025

interface Platform {
    val name: String
}
expect fun getPlatform(): Platform

expect fun onApplicationStartPlatformSpecific()

expect fun logMessage(message: String)
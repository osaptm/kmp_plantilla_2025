package com.gonzapolleria.kmp2025

interface Platform {
    val name: String
}
expect fun getPlatform(): Platform
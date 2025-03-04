package com.gonzapolleria.roomexample

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
package com.gonzapolleria.kmp2025.login

expect class GoogleAuthClient() {
    fun isSingedIn():Boolean
    suspend fun signIn(): Boolean
    suspend fun signOut()
}
package com.gonzapolleria.kmp2025.example_ktor_coil.remote

import com.gonzapolleria.kmp2025.example_ktor_coil.remote.response.Respuesta
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ApiService(private val httpClient: HttpClient){
    suspend fun getMedia() : Respuesta {
        return httpClient.get("").body()
    }
}
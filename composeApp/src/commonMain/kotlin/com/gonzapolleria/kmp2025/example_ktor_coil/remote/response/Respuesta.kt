package com.gonzapolleria.kmp2025.example_ktor_coil.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Respuesta(
    @SerialName("image") val image: String,
    val video: String,
)

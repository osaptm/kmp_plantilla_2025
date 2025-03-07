package com.gonzapolleria.kmp2025.shared.di

import com.gonzapolleria.kmp2025.shared.room.MovieDatabase
import com.gonzapolleria.kmp2025.shared.room.dao.MovieDao
import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.module.Module
import org.koin.dsl.module

fun sharedModule(): Module = module {
    //KTOR CLIENTE PARA ACCESO A APIS
    single {
        HttpClient{
            install(ContentNegotiation){
                json(json = Json{ignoreUnknownKeys = true}, contentType = ContentType.Any)
            }
            install(DefaultRequest){
                url{
                    protocol = URLProtocol.HTTPS
                    host = "getmedia-2ylncwodbq-uc.a.run.app"
                    //parameters.append("page", "1")
                    //parameters.append("key", "")
                }
            }
        }
    }
    single<MovieDao> { get<MovieDatabase>().getMovieDao() }
}
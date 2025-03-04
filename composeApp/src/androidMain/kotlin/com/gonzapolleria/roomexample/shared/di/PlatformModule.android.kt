package com.gonzapolleria.roomexample.shared.di

import com.gonzapolleria.roomexample.application.database.MovieDatabase
import com.gonzapolleria.roomexample.application.database.getDatabaseBuilder
import com.gonzapolleria.roomexample.application.database.getMovieDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module = module {
    single<MovieDatabase> {
        val builder = getDatabaseBuilder(context = get())
        getMovieDatabase(builder)
    }
}
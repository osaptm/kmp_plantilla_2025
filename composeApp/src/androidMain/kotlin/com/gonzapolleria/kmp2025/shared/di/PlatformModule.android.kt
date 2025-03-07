package com.gonzapolleria.kmp2025.shared.di

import com.gonzapolleria.kmp2025.shared.room.MovieDatabase
import com.gonzapolleria.kmp2025.shared.room.getDatabaseBuilder
import com.gonzapolleria.kmp2025.shared.room.getMovieDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module = module {
    single<MovieDatabase> {
        val builder = getDatabaseBuilder(context = get())
        getMovieDatabase(builder)
    }
}
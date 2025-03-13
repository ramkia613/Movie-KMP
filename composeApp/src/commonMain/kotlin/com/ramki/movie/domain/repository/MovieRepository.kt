package com.ramki.movie.domain.repository

import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    //TODO: Later
    suspend fun getMovies() : Flow<Unit>
}

package com.ramki.movie.data.repository

import com.ramki.movie.data.extension.flowTransform
import com.ramki.movie.data.remote.httpClient
import com.ramki.movie.domain.repository.MovieRepository
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.flow.Flow

class MovieRepositoryImpl : MovieRepository {

    override suspend fun getMovies(): Flow<Unit> {
        return  flowTransform {
            httpClient.get("3/movie/popular").body()
        }
    }
}

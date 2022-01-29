package com.debug.debugflix.data

import com.debug.debugflix.domain.model.Movie

interface DiscoveryRepository {

    suspend fun getMovies(): List<Movie>
}
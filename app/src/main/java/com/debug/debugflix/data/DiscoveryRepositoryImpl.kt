package com.debug.debugflix.data

import com.debug.debugflix.data.api.DiscoverAPI
import com.debug.debugflix.data.exception.DiscoveryRepositoryException
import com.debug.debugflix.data.model.toDomain
import com.debug.debugflix.domain.model.Movie
import javax.inject.Inject

class DiscoveryRepositoryImpl @Inject constructor(
    private val discoverService: DiscoverAPI
) : DiscoveryRepository {

    override suspend fun getMovies(): List<Movie> {
        return try {
            discoverService.getMovies().results.map {
                it.toDomain()
            }
        } catch (ex: Exception){
            throw DiscoveryRepositoryException()
        }
    }
}
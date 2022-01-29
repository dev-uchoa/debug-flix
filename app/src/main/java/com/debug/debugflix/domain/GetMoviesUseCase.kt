package com.debug.debugflix.domain

import com.debug.debugflix.data.DiscoveryRepository
import com.debug.debugflix.domain.model.Movie
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val repository: DiscoveryRepository
) {

    suspend operator fun invoke(): Result<List<Movie>> {
        return try {
            Result.success(repository.getMovies())
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }
}
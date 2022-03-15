package com.debug.debugflix.data.api

import com.debug.debugflix.data.model.BasePaginationRemote
import com.debug.debugflix.data.model.MovieRemote
import retrofit2.http.GET
import retrofit2.http.Query

interface DiscoverAPI {

    @GET("discover/movie")
    suspend fun getMovies(): BasePaginationRemote<List<MovieRemote>>
}
package com.debug.debugflix.main.remoto

data class MovieResponse(
    val adult: Boolean,
    val backdropPath: String,
    val genreIds: List<Int>,
    val id: Int,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
)

data class BaseResponse<out T>(
    val page: Int,
    val results: T,
    val totalPages: Int,
    val totalResults: Int
)
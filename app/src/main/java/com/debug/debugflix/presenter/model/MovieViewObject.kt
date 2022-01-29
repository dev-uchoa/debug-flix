package com.debug.debugflix.presenter.model

import com.debug.debugflix.domain.model.Movie

data class MovieViewObject(
    val name: String,
    val poster: String
) {
    constructor(movie: Movie) : this(
        name = movie.title,
        poster = movie.posterPath
    )
}


package com.puc.cinefy.movie.api.model


data class MovieResponse(
    var page: Int,
    var results: List<Movie>
)
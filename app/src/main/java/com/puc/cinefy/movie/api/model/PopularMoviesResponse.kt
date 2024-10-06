package com.puc.cinefy.movie.api.model


data class PopularMoviesResponse(
    var page: Int,
    var results: List<MovieResponse>
)
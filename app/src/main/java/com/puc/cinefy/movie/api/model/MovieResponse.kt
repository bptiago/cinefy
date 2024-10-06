package com.puc.cinefy.movie.api.model

import com.squareup.moshi.Json

data class MovieResponse(
    var id: Int,
    var title: String,
    var overview: String,
//    var posterPath: String,
    var vote_average: Double,
    var release_date: String
)
package com.puc.cinefy.movie.api

import com.puc.cinefy.movie.api.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Header

internal interface MovieApi {
    @GET("movie/100")
    suspend fun getMovieById(
    ): MovieResponse
}
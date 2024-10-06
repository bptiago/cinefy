package com.puc.cinefy.movie.api

import com.puc.cinefy.movie.api.model.MovieResponse
import com.puc.cinefy.movie.api.model.PopularMoviesResponse
import retrofit2.http.GET

internal interface MovieApi {
    @GET("movie/100")
    suspend fun getMovieById(): MovieResponse

    @GET("movie/popular")
    suspend fun getPopularMovies() : PopularMoviesResponse
}
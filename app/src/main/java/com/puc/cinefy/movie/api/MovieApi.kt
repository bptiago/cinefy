package com.puc.cinefy.movie.api

import com.puc.cinefy.movie.api.model.MovieResponse
import com.puc.cinefy.movie.api.model.PopularMoviesResponse
import retrofit2.http.GET
import retrofit2.http.Path

internal interface MovieApi {
    @GET("movie/{id}")
    suspend fun getMovieById(@Path("id") id: Int): MovieResponse

    @GET("movie/popular")
    suspend fun getPopularMovies() : PopularMoviesResponse
}
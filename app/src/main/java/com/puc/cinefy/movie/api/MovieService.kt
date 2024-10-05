package com.puc.cinefy.movie.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

internal class MovieService {

    val movieApi: MovieApi

    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(AuthInterceptor("eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiZTMyMzNlOWMzODQwODU3M2ZhMGVjOGIxM2ViNTc4ZiIsIm5iZiI6MTcyODE2MjAxMS4zMTg3NjMsInN1YiI6IjY1Zjk5NjU4MzNhMzc2MDE2MTM2MzM3OCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.8cqFsMuHPPQbx1ztn0i7TAlsN47Tk31Ibuhc3ixb2z4"))
        .build()

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        movieApi = retrofit.create(MovieApi::class.java)
    }


    private companion object {
        private const val BASE_URL = "https://api.themoviedb.org/3/"
    }
}
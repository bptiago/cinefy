package com.puc.cinefy.movie.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

internal class MovieService {

    val movieApi: MovieApi

    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(AuthInterceptor(TOKEN))
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
        private const val TOKEN = ""
    }
}

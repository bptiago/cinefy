package com.puc.cinefy.movie.model

import android.content.Context

object MovieSingleton {
    lateinit var movies: List<Movie>
    lateinit var dao: MovieDao

    fun init(context: Context) {
        MovieDatabase.getInstance(context)?.apply {
            dao = movieDao()
            movies = dao.getAll()
        }
    }

    fun addUser(movie: Movie) {
        dao.insert(movie)
        movies = dao.getAll()
    }
}
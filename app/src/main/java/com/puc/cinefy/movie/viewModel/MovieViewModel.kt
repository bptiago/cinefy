package com.puc.cinefy.movie.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.puc.cinefy.movie.api.MovieService
import com.puc.cinefy.movie.api.model.MovieResponse
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {
//    val moviesLiveData = MutableLiveData<List<Movie>>()
    private val movieService = MovieService()
//    private val token = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiZTMyMzNlOWMzODQwODU3M2ZhMGVjOGIxM2ViNTc4ZiIsIm5iZiI6MTcyODE2MjAxMS4zMTg3NjMsInN1YiI6IjY1Zjk5NjU4MzNhMzc2MDE2MTM2MzM3OCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.8cqFsMuHPPQbx1ztn0i7TAlsN47Tk31Ibuhc3ixb2z4"

    private val _movieData: MutableLiveData<MovieResponse> = MutableLiveData()
    val movieData: LiveData<MovieResponse> = _movieData

    fun loadData() = viewModelScope.launch {
        val movie = movieService.movieApi.getMovieById()
        _movieData.value = movie
    }

}

//    fun addUser(movie: Movie){
//        Singleton.addUser(movie)
//        moviesLiveData.value = MovieSingleton.movies
//    }
//
//    fun refresh(){
//        moviesLiveData.value = MovieSingleton.movies
//    }

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

    private val _moviesData: MutableLiveData<MovieResponse> = MutableLiveData()
    val moviesData: LiveData<MovieResponse> = _moviesData

    fun loadData() = viewModelScope.launch {
        val movies = movieService.movieApi.getPopularMovies()
        _moviesData.value = movies
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

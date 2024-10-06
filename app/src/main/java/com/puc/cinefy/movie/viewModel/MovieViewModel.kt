package com.puc.cinefy.movie.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.puc.cinefy.movie.api.MovieService
import com.puc.cinefy.movie.api.model.MovieResponse
import com.puc.cinefy.movie.api.model.PopularMoviesResponse
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {
//    val moviesLiveData = MutableLiveData<List<Movie>>()
    private val movieService = MovieService()

    private val _popularMoviesData: MutableLiveData<PopularMoviesResponse> = MutableLiveData()
    val popularMoviesData: LiveData<PopularMoviesResponse> = _popularMoviesData

    private var _movieData: MutableLiveData<MovieResponse> = MutableLiveData()
    var movieData: LiveData<MovieResponse> = _movieData

    fun loadPopularMovies() = viewModelScope.launch {
        val movies = movieService.movieApi.getPopularMovies()
        _popularMoviesData.value = movies
    }

    fun loadMovie(id: Int) = viewModelScope.launch {
        val movie = movieService.movieApi.getMovieById(id)
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

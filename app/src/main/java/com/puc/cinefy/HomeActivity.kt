package com.puc.cinefy

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.puc.cinefy.databinding.ActivityHomeBinding
import com.puc.cinefy.movie.api.model.MovieResponse
import com.puc.cinefy.movie.presenter.MovieRecyclerViewAdapter
import com.puc.cinefy.movie.viewModel.MovieViewModel

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    lateinit var viewModel: MovieViewModel
    lateinit var movieAdapter: MovieRecyclerViewAdapter
    lateinit var movieRecycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

//        MovieSingleton.init(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        viewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
        movieRecycler = binding.movieRecyclerView
        movieRecycler.layoutManager = LinearLayoutManager(this)

        viewModel.loadData()
        viewModel.moviesData.observe(this) {
            movieAdapter = MovieRecyclerViewAdapter(it.results)
            movieRecycler.adapter = movieAdapter
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


    }

    private fun loadMoviesData(movieData: MovieResponse) {
        movieAdapter = MovieRecyclerViewAdapter(movieData.results)
    }
}
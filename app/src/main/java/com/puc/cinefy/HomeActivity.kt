package com.puc.cinefy

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.puc.cinefy.databinding.ActivityHomeBinding
import com.puc.cinefy.movie.api.model.PopularMoviesResponse
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

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        viewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
        movieRecycler = binding.movieRecyclerView
        movieRecycler.layoutManager = LinearLayoutManager(this)

        viewModel.loadPopularMovies()
        viewModel.popularMoviesData.observe(this) {
            movieAdapter = MovieRecyclerViewAdapter(it.results, this, object: MovieRecyclerViewAdapter.ItemClickListener {
                override fun onClick(view: View, position: Int) {
                    val movie = it.results[position]
                    val intent = Intent(applicationContext, MovieActivity::class.java)
                    intent.putExtra("MOVIE_ID", movie.id.toString())
                    startActivity(intent)
                }
            })
            movieRecycler.adapter = movieAdapter
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
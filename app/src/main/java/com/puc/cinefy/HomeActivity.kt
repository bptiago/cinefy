package com.puc.cinefy

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.puc.cinefy.databinding.ActivityHomeBinding
import com.puc.cinefy.movie.api.model.MovieResponse
import com.puc.cinefy.movie.model.MovieSingleton
import com.puc.cinefy.movie.viewModel.MovieViewModel
import com.puc.cinefy.movie.viewModel.MovieViewModelFactory
import com.puc.cinefy.viewModel.MainViewModel

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    lateinit var viewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

//        MovieSingleton.init(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        viewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
        viewModel.loadData()
        viewModel.movieData.observe(this, ::updateMovieData)

        initComponents()
//        viewModel = MovieViewModelFactory().create(MovieViewModel::class.java)
//        viewModel.moviesLiveData.observe(this) {
//            binding.movieRecyclerView.adapter?.notifyDataSetChanged()
//        }
//
//        binding.movieRecyclerView.layoutManager = LinearLayoutManager(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


    }

    private fun initComponents() {

    }

    private fun updateMovieData(movieData: MovieResponse) {
        binding.apply {
            textView5.text = movieData.overview
        }
    }
}
package com.puc.cinefy

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.puc.cinefy.databinding.ActivityMovieBinding
import com.puc.cinefy.movie.viewModel.MovieViewModel
import java.util.Locale

class MovieActivity : AppCompatActivity() {
    lateinit var binding: ActivityMovieBinding
    lateinit var viewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)
        viewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
//

        val movieId = intent.getStringExtra("MOVIE_ID")?.toInt() ?: 0
        viewModel.loadMovie(movieId)
        viewModel.movieData.observe(this) {
            binding.txtTitle.text = it.title
            val strRating = String.format(Locale.US, "%.2f", it.vote_average)
            binding.txtRating.text = "TMDB $strRating"
            binding.txtOverview.text = it.overview
            binding.txtGenre.text = it.genres[0].name
            val backgroudImageUrl = "https://image.tmdb.org/t/p/original" + it.backdrop_path
            Glide.with(this).load(backgroudImageUrl).into(binding.imageView2)
        }

        binding.btnBack.setOnClickListener {
            this.finish()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
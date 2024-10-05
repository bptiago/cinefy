package com.puc.cinefy.movie.presenter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.puc.cinefy.databinding.RecyclerItemBinding
import com.puc.cinefy.movie.model.Movie
import com.puc.cinefy.movie.model.MovieSingleton

class MovieRecyclerViewAdapter() : RecyclerView.Adapter<MovieRecyclerViewAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: RecyclerItemBinding) :RecyclerView.ViewHolder(binding.root){
        fun bind(movie: Movie){
            binding.apply {
                textView1.text = movie.title
                textView2.text = movie.id.toString()
//                root.setOnClickListener {
//                    itemClickListener?.onClick(binding.root,adapterPosition)
//                }
//                root.setOnLongClickListener {
//                    itemClickListener?.onLongClick(binding.root,adapterPosition)
//                    true
//                }
            }
        }
    }

    var counter = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RecyclerItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)
        counter++
        Log.d("Recycler","onCreateViewHolder $counter")
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        MovieSingleton.movies[position].apply {
            holder.bind(this)
        }
        Log.d("Recycler","onBindViewHolder $position")
    }
    override fun getItemCount() = MovieSingleton.movies.size
}
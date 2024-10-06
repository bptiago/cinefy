package com.puc.cinefy.movie.presenter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.puc.cinefy.databinding.RecyclerItemBinding
import com.puc.cinefy.movie.api.model.MovieResponse

class MovieRecyclerViewAdapter(private val movies: List<MovieResponse>) : RecyclerView.Adapter<MovieRecyclerViewAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: RecyclerItemBinding) :RecyclerView.ViewHolder(binding.root){
        fun bind(movie: MovieResponse){
            binding.apply {
                textView1.text = movie.id.toString()
                textView2.text = movie.overview
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
        movies[position].apply {
            holder.bind(this)
        }
        Log.d("Recycler","onBindViewHolder $position")
    }
    override fun getItemCount() = movies.size
}
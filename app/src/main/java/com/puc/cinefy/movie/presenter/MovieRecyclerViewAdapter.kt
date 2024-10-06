package com.puc.cinefy.movie.presenter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.puc.cinefy.databinding.RecyclerItemBinding
import com.puc.cinefy.movie.api.model.MovieResponse
import java.util.Locale

class MovieRecyclerViewAdapter(private val movies: List<MovieResponse>, private val context: Context,val itemClickListener: ItemClickListener?) : RecyclerView.Adapter<MovieRecyclerViewAdapter.ViewHolder>() {

    interface ItemClickListener{
        fun onClick(view: View, position:Int)
    }

    inner class ViewHolder(val binding: RecyclerItemBinding) :RecyclerView.ViewHolder(binding.root){

        fun bind(movie: MovieResponse){
            binding.apply {
                val posterImageUrl = "https://image.tmdb.org/t/p/original" + movie.poster_path
                Glide.with(context).load(posterImageUrl).into(imageView3)
                txtTitle.text = movie.title
                val strRating = String.format(Locale.US, "%.2f", movie.vote_average)
                val strDate = movie.release_date.replace("-", "/")
                val strInfo = "$strDate  -  $strRating"
                txtInfo.text = strInfo

                root.setOnClickListener {
                    itemClickListener?.onClick(binding.root,adapterPosition)
                }
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
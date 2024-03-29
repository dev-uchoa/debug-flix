package com.debug.debugflix.presenter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.debug.debugflix.R
import com.debug.debugflix.presenter.model.MovieViewObject

private const val basePosterUrl = "https://image.tmdb.org/t/p/w500/"

class MovieAdapter(
    private val movies: List<MovieViewObject>
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_item, parent, false)

        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]

        holder.apply {
            movieName.text = movie.name
            poster.load(
                basePosterUrl + movie.poster
            )
        }
    }

    override fun getItemCount() = movies.size

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val movieName: TextView = itemView.findViewById(R.id.movie_name)
        val poster: ImageView = itemView.findViewById(R.id.poster)
    }
}
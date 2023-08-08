package com.cursosandroidant.ejemplorecyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cursosandroidant.ejemplorecyclerview.R
import com.cursosandroidant.ejemplorecyclerview.model.Movie

class MovieAdapter(val movieList: List<Movie>) : RecyclerView.Adapter<MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MovieViewHolder(layoutInflater.inflate(R.layout.item_movie, parent, false))

    }

    override fun getItemCount(): Int = movieList.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = movieList[position]
        holder.render(item)
    }
}
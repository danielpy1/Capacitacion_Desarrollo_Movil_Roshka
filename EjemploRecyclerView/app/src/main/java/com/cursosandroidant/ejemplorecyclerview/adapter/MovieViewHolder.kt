package com.cursosandroidant.ejemplorecyclerview.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.cursosandroidant.ejemplorecyclerview.databinding.ItemMovieBinding
import com.cursosandroidant.ejemplorecyclerview.model.Movie

class MovieViewHolder(val view: View):RecyclerView.ViewHolder(view) {

    val binding = ItemMovieBinding.bind(view)
    fun render(movie: Movie){
        binding.nameMovie.text=movie.Nombre
    }
}
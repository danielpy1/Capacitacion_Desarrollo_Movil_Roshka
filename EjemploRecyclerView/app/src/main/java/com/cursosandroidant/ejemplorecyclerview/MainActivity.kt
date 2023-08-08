package com.cursosandroidant.ejemplorecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.cursosandroidant.ejemplorecyclerview.adapter.MovieAdapter
import com.cursosandroidant.ejemplorecyclerview.databinding.ActivityMainBinding
import com.cursosandroidant.ejemplorecyclerview.model.MovieProvider

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.recyclerMovies.layoutManager = LinearLayoutManager(this)
        binding.recyclerMovies.adapter = MovieAdapter(MovieProvider.ListMovies)
    }
}
package com.cursosandroidant.exampleretrofit.model

data class PopularMovieResult(
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)
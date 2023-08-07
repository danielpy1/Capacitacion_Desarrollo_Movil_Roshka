package com.cursosandroidant.exampleretrofit.network

import retrofit2.Call
import com.cursosandroidant.exampleretrofit.model.PopularMovieResult
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

private const val URL_BASE = "https://api.themoviedb.org/3/"
private const val API_KEY = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIwMDlkM2FkMGZlNjUxMjQwYjllNjEyYjNiN2I3ZWE4NiIsInN1YiI6IjY0Y2QxZTQ3NDNjZDU0MDExYzhkZjlhMSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.bMrTWGJ9ZfD2IRazfZuQHOcjVJXy9jRh_-YNFzH07Yg"


private val retrofit= Retrofit.Builder()
    .baseUrl(URL_BASE)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface ApiService{
    @Headers("Authorization: Bearer $API_KEY")
    @GET("movie/popular")
    fun getPopularMovies(): Call<PopularMovieResult>

}

object Api{
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}
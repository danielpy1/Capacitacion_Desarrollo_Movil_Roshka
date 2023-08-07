package com.cursosandroidant.exampleretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.cursosandroidant.exampleretrofit.model.PopularMovieResult
import com.cursosandroidant.exampleretrofit.network.Api
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Api.retrofitService.getPopularMovies().enqueue(object : Callback<PopularMovieResult?> {
            override fun onResponse(
                call: Call<PopularMovieResult?>,
                response: Response<PopularMovieResult?>
            ) {
                val popularMovieResult = response.body()
                var ListMovies=popularMovieResult?.results
                Log.i("Lista de peliculas", "PopularMovieResult: ${ListMovies}")
            }

            override fun onFailure(call: Call<PopularMovieResult?>, t: Throwable) {
                Log.i("Error en getPopularMovies", "Error: $t")
            }
        })
    }
}
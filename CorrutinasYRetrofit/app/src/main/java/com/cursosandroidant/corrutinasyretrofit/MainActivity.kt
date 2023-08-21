package com.cursosandroidant.corrutinasyretrofit

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.cursosandroidant.corrutinasyretrofit.databinding.ActivityMainBinding
import com.cursosandroidant.corrutinasyretrofit.dogadapter.DogAdapter
import com.google.android.material.internal.ViewUtils.hideKeyboard
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Locale

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var dogAdapter: DogAdapter
    private var dogList = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        iniRecyclerView()
        binding.svDogs.setOnQueryTextListener(this)
    }

    private fun iniRecyclerView() {
        dogAdapter = DogAdapter(dogList)
        binding.rvDogs.layoutManager = LinearLayoutManager(this)
        binding.rvDogs.adapter = dogAdapter
    }

    //https://dog.ceo/api/breed/hound/images
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breed/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun seachByBreed(breed: String) {
        val apiDog = getRetrofit().create(ApiService::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val call = apiDog.getDogsByBreeds("$breed/images")
            val puppies = call.body()
            runOnUiThread {
                if (call.isSuccessful) {
                    val images = puppies?.images ?: emptyList()
                    dogList.clear()
                    dogList.addAll(images)
                    dogAdapter.notifyDataSetChanged()
                    hideKeyboard()
                } else {
                    showError()
                }
            }

        }
//        api.getDogsByBreeds("$breed/images").enqueue(object : Callback<DogResponse>{
//            override fun onResponse(call: Call<DogResponse>, response: Response<DogResponse>) {
//                if (response.isSuccessful){
//                    val images = response.body()?.images ?: emptyList()
//                    binding.rvDogImages.adapter = DogAdapter(images)
//                }
//            }
//
//            override fun onFailure(call: Call<DogResponse>, t: Throwable) {
//                Toast.makeText(this@MainActivity, "Error", Toast.LENGTH_SHORT).show()
//            }
//
//        })
    }

    private fun hideKeyboard() {
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
    }

    private fun showError() {
        Toast.makeText(this, "Error al buscar", Toast.LENGTH_LONG).show()
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (!query.isNullOrEmpty()) {
            seachByBreed(query.lowercase(Locale.ROOT))
        }else{
            Toast.makeText(this, "Ingrese una raza", Toast.LENGTH_SHORT).show()
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }

}
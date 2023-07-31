package com.cursosandroidant.ejerciciogenerala

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import kotlin.random.Random



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnJugar: Button = findViewById(R.id.btnPlay)
        btnJugar.setOnClickListener {
        var dados:MutableList<Int> = mutableListOf()
        var imagenesDados:MutableList<ImageView> = mutableListOf()
            for(i in 1..5){
                dados.add(Random.nextInt(1,7))
                val resID = resources.getIdentifier("dice$i", "id", packageName)
                val imageView = findViewById<ImageView>(resID)
                imagenesDados.add(imageView)
                val resourceID = resources.getIdentifier("d${dados[i-1]}", "drawable", packageName)
                imagenesDados[i-1].setImageResource(resourceID)
            }
        }
    }
}
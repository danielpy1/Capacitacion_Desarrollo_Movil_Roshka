package com.cursosandroidant.ejerciciodado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var dado: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dado = findViewById(R.id.imageView)
        val throwsButton: Button = findViewById(R.id.throwDice)
        throwsButton.setOnClickListener {
            throwDice()
        }
        val resetButton: Button = findViewById(R.id.reset)
        resetButton.setOnClickListener {
            resetDice()
        }

    }

    fun throwDice(){
        val numero = Random.nextInt(1, 7)
        when(numero){
            1 -> dado.setImageResource(R.drawable.d1)
            2 -> dado.setImageResource(R.drawable.d2)
            3 -> dado.setImageResource(R.drawable.d3)
            4 -> dado.setImageResource(R.drawable.d4)
            5 -> dado.setImageResource(R.drawable.d5)
            6 -> dado.setImageResource(R.drawable.d6)
        }
    }

    fun resetDice(){
        dado.setImageResource(R.drawable.d0)
    }

}
package com.cursosandroidant.ejerciciotrivia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        val playerName = intent.getStringExtra("playerName")
//        Log.i("Mensaje Rapidos", "Nombre del jugador: $playerName")
    }
}
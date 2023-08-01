package com.cursosandroidant.ejerciciotrivia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import android.content.Intent
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnPlay= findViewById<AppCompatButton>(R.id.btnPlay)
        val editText= findViewById<AppCompatEditText>(R.id.playerName)
        lateinit var playerName:String

        btnPlay.setOnClickListener(){
            playerName=editText.text.toString()
            if(playerName.isNotEmpty()){
                val intent = Intent(this, FirstActivity::class.java)
                intent.putExtra("playerName", playerName)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Ingrese el nombre del jugador", Toast.LENGTH_LONG).show()
            }

        }
    }
}
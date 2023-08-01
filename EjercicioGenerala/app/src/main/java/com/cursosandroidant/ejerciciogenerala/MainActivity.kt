package com.cursosandroidant.ejerciciogenerala

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnJugar: Button = findViewById(R.id.btnPlay)
        var textViewJugada: TextView = findViewById(R.id.jugada)
        btnJugar.setOnClickListener {
            var dados:MutableList<Int> = mutableListOf()
            var imagenesDados:MutableList<ImageView> = mutableListOf()
            var jugada:String="?"
                for(i in 1..5){
                    dados.add(Random.nextInt(1,7))
                    val resID = resources.getIdentifier("dice$i", "id", packageName)
                    val imageView = findViewById<ImageView>(resID)
                    imagenesDados.add(imageView)
                    val resourceID = resources.getIdentifier("d${dados[i-1]}", "drawable", packageName)
                    imagenesDados[i-1].setImageResource(resourceID)
                }
                dados.sort()
                var primerDado:Int = dados[0]
                var banderaEscalera:Boolean=true
                if(
                    ( dados[0]!=dados[1] && dados[1]==dados[2] && dados[2]==dados[3] && dados[3]==dados[4] )
                    ||
                    ( dados[0]==dados[1] && dados[1]==dados[2] && dados[2]==dados[3] && dados[3]!=dados[4] )
                ) {
                    jugada="POKER"
                }else if(
                    ( dados[0]==dados[1] && dados[1]!=dados[2] && dados[2]==dados[3] && dados[3]==dados[4] )
                    ||
                    ( dados[0]==dados[1] && dados[1]==dados[2] && dados[2]!=dados[3] && dados[3]==dados[4] )
                ){
                    jugada="FULL"
                }else {
                    if (dados[0] == 1 && dados[1] == 3) {
                        dados[0] = 7
                    }
                    for (i in 0..3) {
                        if (dados[i] + 1 != dados[i + 1]) {
                            banderaEscalera = false
                            break
                        }
                    }
                    if (banderaEscalera) {
                        jugada = "ESCALERA"
                    }else{
                        if(dados[0]==dados[1] && dados[1]==dados[2] && dados[2]==dados[3] && dados[3]==dados[4]){
                            jugada="GENERALA"
                        }else{
                            jugada="NADA"
                        }
                    }
                }
            textViewJugada.setText(jugada)
            }
        }
    }
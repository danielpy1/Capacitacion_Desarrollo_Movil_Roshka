package com.cursosandroidant.ejerciciotrivia.model

data class Pregunta(
    val pregunta: String,
    val opciones: List<String>,
    val respuesta: String
)

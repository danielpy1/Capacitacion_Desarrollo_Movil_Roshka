package com.cursosandroidant.corrutinasyretrofit.model

import com.google.gson.annotations.SerializedName
data class DogResponse(
    @SerializedName("message")
    var images: List<String>,
    var status: String)

package com.cursosandroidant.corrutinasyretrofit.dogadapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.cursosandroidant.corrutinasyretrofit.databinding.ItemDogBinding
import com.squareup.picasso.Picasso

class DogViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val bindig = ItemDogBinding.bind(view)
    fun bind(image: String) {
        Picasso.get().load(image).into(bindig.ivDog)
    }


}

package com.cursosandroidant.ejemplomvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cursosandroidant.ejemplomvvm.model.QuoteModel
import com.cursosandroidant.ejemplomvvm.model.QuoteProvider

class QuoteViewModel : ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>()

    fun randomQuote() {
        quoteModel.postValue(QuoteProvider.getQuote())
    }
}
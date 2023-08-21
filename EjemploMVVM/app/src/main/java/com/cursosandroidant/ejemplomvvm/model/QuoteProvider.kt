package com.cursosandroidant.ejemplomvvm.model

class QuoteProvider {

    companion object {
        fun getQuote(): QuoteModel {
            val randomNumber = (0..QuoteList.size - 1).random()
            return QuoteList[randomNumber]
        }

        private val QuoteList = listOf<QuoteModel>(

            QuoteModel("Be yourself; everyone else is already taken", "Oscar Wilde"),
            QuoteModel("I have nothing to declare except my genius", "Oscar Wilde"),
            QuoteModel("The truth is rarely pure and never simple", "Oscar Wilde"),
            QuoteModel(
                "I am so clever that sometimes I don't understand a single word of what I am saying",
                "Oscar Wilde"
            ),
            QuoteModel(
                "Fashion is a form of ugliness so intolerable that we have to alter it every six months",
                "Oscar Wilde"
            ),
            QuoteModel("The only way to get rid of temptation is to yield to it", "Oscar Wilde"),
            QuoteModel("I can resist everything except temptation", "Oscar Wilde"),
            QuoteModel("Always forgive your enemies; nothing annoys them so much", "Oscar Wilde"),

            )
    }
}
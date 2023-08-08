package com.cursosandroidant.ejemplorecyclerview.model

class MovieProvider {
    companion object{
        val ListMovies= listOf<Movie>(
            Movie("The Shawshank Redemption"),
            Movie("The Godfather"),
            Movie("The Dark Knight"),
            Movie("The Godfather: Part II"),
            Movie("The Lord of the Rings: The Return of the King"),
            Movie("Pulp Fiction"),
            Movie("Schindler's List"),
        )
    }
}
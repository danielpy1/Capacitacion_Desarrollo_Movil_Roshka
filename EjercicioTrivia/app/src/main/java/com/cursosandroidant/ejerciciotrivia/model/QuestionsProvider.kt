package com.cursosandroidant.ejerciciotrivia.model

class QuestionsProvider {
    companion object {
        val questions = listOf<Pregunta>(
            Pregunta(
                "¿Cuál es la capital de España?",
                listOf("Madrid", "Barcelona", "Sevilla", "Valencia"),
                "Madrid"
            ),
            Pregunta(
                "¿Cuál es la capital de Francia?",
                listOf("París", "Lyon", "Marsella", "Toulouse"),
                "París"
            ),
            Pregunta(
                "¿Cuál es la capital de Italia?",
                listOf("Roma", "Milán", "Nápoles", "Turín"),
                "Roma"
            ),
            Pregunta(
                "¿Cuál es la capital de Portugal?",
                listOf("Lisboa", "Oporto", "Coímbra", "Braga"),
                "Lisboa"
            ),
            Pregunta(
                "¿Cuál es la capital de Alemania?",
                listOf("Berlín", "Hamburgo", "Múnich", "Colonia"),
                "Berlín"
            ),
            Pregunta(
                "¿Cuál es la capital de Reino Unido?",
                listOf("Londres", "Birmingham", "Glasgow", "Liverpool"),
                "Londres"
            ),
            Pregunta(
                "¿Cuál es la capital de Irlanda?",
                listOf("Dublín", "Cork", "Galway", "Limerick"),
                "Dublín"
            ),
            Pregunta(
                "¿Cuál es la capital de Bélgica?",
                listOf("Bruselas", "Amberes", "Gante", "Brujas"),
                "Bruselas"
            ),
            Pregunta(
                "¿Cuál es la capital de Holanda?",
                listOf("Ámsterdam", "Róterdam", "La Haya", "Utrecht"),
                "Ámsterdam"
            ),
            Pregunta(
                "¿Cuál es la capital de Suiza?",
                listOf("Berna", "Ginebra", "Zúrich", "Basilea"),
                "Berna"
            ),
            Pregunta(
                "¿Cuál es la capital de Suecia?",
                listOf("Estocolmo", "Gotemburgo", "Malmö", "Uppsala"),
                "Estocolmo"
            )
        )
    }
}
package com.cursosandroidant.ejerciciotrivia

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.cursosandroidant.ejerciciotrivia.model.QuestionsProvider


class FirstFragment : Fragment() {

    lateinit var btnAnswer1: Button
    lateinit var btnAnswer2: Button
    lateinit var btnAnswer3: Button
    lateinit var btnAnswer4: Button
    lateinit var textPregunta: TextView
    val  QuestionList = QuestionsProvider.questions
    var numeroPreguntas = QuestionList.size
    var score = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragment_first = inflater.inflate(R.layout.fragment_first, container, false)
        var preguntaActual = 0

        textPregunta = fragment_first.findViewById<TextView>(R.id.textQuestion)
        btnAnswer1 = fragment_first.findViewById<Button>(R.id.answer1)
        btnAnswer2 = fragment_first.findViewById<Button>(R.id.answer2)
        btnAnswer3 = fragment_first.findViewById<Button>(R.id.answer3)
        btnAnswer4 = fragment_first.findViewById<Button>(R.id.answer4)

        btnAnswer1.setBackgroundResource(R.drawable.green_button)


        btnAnswer1.setOnClickListener {
            if (checkQuestion(btnAnswer1.text.toString(), preguntaActual)) {
                score++
                btnAnswer1.setTextAppearance(R.style.GreenButtonStyle)
                preguntaActual++
                setearValores(preguntaActual)

            }else{
                btnAnswer1.setTextAppearance(R.style.RedButtonStyle)
                preguntaActual++
                setearValores(preguntaActual)
            }
        }
        btnAnswer2.setOnClickListener {
            if (checkQuestion(btnAnswer2.text.toString(), preguntaActual)) {
                score++
                btnAnswer2.setTextAppearance(R.style.GreenButtonStyle)
                preguntaActual++
                setearValores(preguntaActual)
            }else{
                btnAnswer2.setTextAppearance(R.style.RedButtonStyle)
                preguntaActual++
                setearValores(preguntaActual)
            }
        }
        btnAnswer3.setOnClickListener {
            if (checkQuestion(btnAnswer3.text.toString(), preguntaActual)) {
                score++
                btnAnswer3.setTextAppearance(R.style.GreenButtonStyle)
                preguntaActual++
                setearValores(preguntaActual)
            }else{
                btnAnswer3.setTextAppearance(R.style.RedButtonStyle)
                preguntaActual++
                setearValores(preguntaActual)
            }
        }
        btnAnswer4.setOnClickListener {
            if (checkQuestion(btnAnswer4.text.toString(), preguntaActual)) {
                score++
                btnAnswer4.setTextAppearance(R.style.GreenButtonStyle)
                preguntaActual++
                setearValores(preguntaActual)
            }else{
                btnAnswer4.setTextAppearance(R.style.RedButtonStyle)
                preguntaActual++
                setearValores(preguntaActual)
            }
        }
        setearValores(preguntaActual)

        return fragment_first
    }

    fun checkQuestion(respuesta: String, preguntaActual: Int): Boolean {
        return if (respuesta == QuestionsProvider.questions[preguntaActual].respuesta) true else false
    }

    fun setearValores(preguntaActual: Int){
        val navController = findNavController()

        if(preguntaActual== 0){
            textPregunta.text = QuestionList[preguntaActual].pregunta
            btnAnswer1.text = QuestionList[preguntaActual].opciones[0]
            btnAnswer2.text = QuestionList[preguntaActual].opciones[1]
            btnAnswer3.text = QuestionList[preguntaActual].opciones[2]
            btnAnswer4.text = QuestionList[preguntaActual].opciones[3]
        }else{

            Handler(Looper.getMainLooper()).postDelayed({

//                btnAnswer1.setTextAppearance(R.style.DefaultButtonStyle)
//                btnAnswer2.setTextAppearance(R.style.DefaultButtonStyle)
//                btnAnswer3.setTextAppearance(R.style.DefaultButtonStyle)
//                btnAnswer4.setTextAppearance(R.style.DefaultButtonStyle)

                if (preguntaActual >= numeroPreguntas) {
                    //hacer un intent a la pantalla de resultados
                    val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(score)
                    navController.navigate(action)

                } else {
                    textPregunta.text = QuestionList[preguntaActual].pregunta
                    btnAnswer1.text = QuestionList[preguntaActual].opciones[0]
                    btnAnswer2.text = QuestionList[preguntaActual].opciones[1]
                    btnAnswer3.text = QuestionList[preguntaActual].opciones[2]
                    btnAnswer4.text = QuestionList[preguntaActual].opciones[3]
                }

            }, 500)

        }

    }
}
package com.cursosandroidant.ejerciciotrivia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.navigation.fragment.navArgs


class SecondFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragment=   inflater.inflate(R.layout.fragment_second, container, false)
        val args: SecondFragmentArgs by navArgs()
        val score = fragment.findViewById<AppCompatTextView>(R.id.textScore)
        score.text = args.score.toString()
        return fragment
    }

}
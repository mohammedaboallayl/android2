package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.view.ContentInfo
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class Starter : Fragment() {
    // TODO: Rename and change types of parameters


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_starter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.Explore).setOnClickListener {
            val preferance=context?.getSharedPreferences("Login",Context.MODE_PRIVATE)
            if(preferance?.getString("email","mob")=="mob") {
                findNavController().navigate(R.id.action_starter_to_commingSoonReciqule)
            }else{
                findNavController().navigate(R.id.action_starter_to_signUp)
            }


        }
    }

}
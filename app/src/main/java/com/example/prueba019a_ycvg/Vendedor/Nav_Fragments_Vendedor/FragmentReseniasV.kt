package com.example.prueba019a_ycvg.Vendedor.Nav_Fragments_Vendedor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.prueba019a_ycvg.R

class FragmentReseniasV : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_resenias_v, container, false)
    }

}
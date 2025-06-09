package com.example.prueba019a_ycvg.Vendedor.Nav_Fragments_Vendedor

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.prueba019a_ycvg.R
import com.example.prueba019a_ycvg.Vendedor.Bottom_Nav_Fragments_Vendedor.FragmentMisProductosV
import com.example.prueba019a_ycvg.Vendedor.Bottom_Nav_Fragments_Vendedor.FragmentOrdenesV
import com.example.prueba019a_ycvg.databinding.FragmentInicioVBinding

class FragmentInicioV : Fragment() {

    private lateinit var binding : FragmentInicioVBinding
    private lateinit var mContext : Context

    override fun onAttach(context: Context) {
        mContext = context
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentInicioVBinding.inflate(inflater, container, false)

        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.op_mis_productos_v -> {
                    replaceFragment(FragmentMisProductosV())
                }
                R.id.op_mis_ordenes_v -> {
                    replaceFragment(FragmentOrdenesV())
                }
            }
            true
        }

        replaceFragment(FragmentMisProductosV())
        binding.bottomNavigation.selectedItemId = R.id.op_mis_productos_v

        binding.addFav.setOnClickListener{
            Toast.makeText(
                mContext,
                "Has presionado el botón flotante",
                Toast.LENGTH_SHORT
            ).show()
        }
        return binding.root
    }

    private fun replaceFragment(fragment: Fragment) {
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.bottomFragment, fragment)
            .commit()
    }
}



package com.example.prueba019a_ycvg.Vendedor

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import com.example.prueba019a_ycvg.R
import com.example.prueba019a_ycvg.databinding.ActivityRegistroVendedorBinding
import com.google.firebase.auth.FirebaseAuth
import java.util.regex.Pattern

class RegistroVendedorActivity : AppCompatActivity() {


    private lateinit var binding: ActivityRegistroVendedorBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegistroVendedorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Esperar por favor")
        progressDialog.setCanceledOnTouchOutside(false)


        binding.btnRegistrarV.setOnClickListener {
            validarInformacion()
        }

    }

    private var nombres = ""
    private var email = ""
    private var password = ""
    private var cpassword = ""
    private fun validarInformacion() {
        nombres = binding.etNombresV.text.toString().trim()
        email = binding.etEmailV.text.toString().trim()
        password = binding.etPasswordV.text.toString().trim()
        cpassword = binding.etCPasswordV.text.toString().trim()

        if (nombres.isEmpty()){
            binding.etNombresV.error = "Ingrese su nombre completo"
            binding.etNombresV.requestFocus()
        } else if (email.isEmpty()) {
            binding.etEmailV.error = "Ingrese su email"
            binding.etEmailV.requestFocus()
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            binding.etEmailV.error = "Email no válido"
            binding.etEmailV.requestFocus()
        } else if (password.isEmpty()){
            binding.etPasswordV.error = "Ingrese su password"
            binding.etPasswordV.requestFocus()
        } else if (password.length >= 6){
            binding.etPasswordV.error = "Necesita 6 o más carácteres"
            binding.etPasswordV.requestFocus()
        } else if (cpassword.isEmpty()){
            binding.etCPasswordV.error = "Confirme su password"
            binding.etCPasswordV.requestFocus()
        } else if (password != cpassword){
            binding.etCPasswordV.error = "No coincide su password"
            binding.etCPasswordV.requestFocus()
        } else {
            registrarVendedor()
        }
    }

    private fun registrarVendedor() {

    }
}

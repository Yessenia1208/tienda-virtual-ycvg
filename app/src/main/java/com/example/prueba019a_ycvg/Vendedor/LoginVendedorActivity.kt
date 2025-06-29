package com.example.prueba019a_ycvg.Vendedor

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.prueba019a_ycvg.databinding.ActivityLoginVendedorBinding
import com.google.firebase.auth.FirebaseAuth

class LoginVendedorActivity : AppCompatActivity() {

    private lateinit var biding: ActivityLoginVendedorBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var progressDialog: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        biding = ActivityLoginVendedorBinding.inflate(layoutInflater)
        setContentView(biding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Espere por favor, verificando cuenta")
        progressDialog.setCanceledOnTouchOutside(false)

        biding.btnLoginV.setOnClickListener {
            validarInfor()
        }
        biding.tvRegistrarV.setOnClickListener{
            startActivity(Intent(applicationContext, RegistroVendedorActivity::class.java))
        }
    }

    private var email = ""
    private var password = ""
    private fun validarInfor() {
        email = biding.etEmailV.text.toString().trim()
        password = biding.etPasswordV.text.toString().trim()

        if(email.isEmpty()){
            biding.etEmailV.error = "Ingrese email"
            biding.etEmailV.requestFocus()
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            biding.etEmailV.error = "Email no válido"
            biding.etEmailV.requestFocus()
        } else if (password.isEmpty()){
            biding.etPasswordV.error = "Ingrese passwrod"
            biding.etPasswordV.requestFocus()
        } else {
            loginVendedor()
        }
    }

    private fun loginVendedor() {
        progressDialog.setMessage("Ingresando a su cuenta")
        progressDialog.show()

        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                progressDialog.dismiss()
                startActivity(Intent(this, MainActivityVendedor::class.java))
                finishAffinity()
                Toast.makeText(
                    this,
                    "Bienvenido(a)",
                    Toast.LENGTH_SHORT
                ).show()
            }

            .addOnFailureListener{e->
                progressDialog.dismiss()
                Toast.makeText(
                    this,
                    "No se pudo iniciar sesión debido a ${e.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
    }
}




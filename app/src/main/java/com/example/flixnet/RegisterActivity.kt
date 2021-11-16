package com.example.flixnet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.flixnet.databinding.ActivityMainBinding
import com.example.flixnet.databinding.ActivityRegisterBinding
import com.example.flixnet.objetos.Usuario
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registerbutton.setOnClickListener{
            register(it)
        }

        auth = Firebase.auth

    }
    // metodo de registro de firebase CreateUserWithEmailAndPassword(....)

    fun register(view: View){

        val name : String = binding.name.text.toString().trim()
        val surname : String = binding.surname.text.toString().trim()
        val username : String = binding.username.text.toString().trim()
        val email : String = binding.email.text.toString().trim()
        val password : String = binding.password.text.toString().trim()

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {

                if (it.isSuccessful) {
                    val intencion = Intent(this, LoginActivity::class.java)

                    val intencionVuelta = Intent()
                    //intencionVuelta.putExtra(..., ...)
                    setResult(RESULT_OK, intencion)
                    finish()

                } else {
                    Snackbar.make(view, R.string.error_de_registro, Snackbar.LENGTH_LONG).show()
                }

            }
    }
}
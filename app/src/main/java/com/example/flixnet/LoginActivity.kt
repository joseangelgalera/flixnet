package com.example.flixnet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.flixnet.databinding.ActivityLoginBinding
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        // setContentView(R.layout.activity_login)
        setContentView(binding.root)

        binding.loginbutton.setOnClickListener {
            //    Toast.makeText(this, "Email:${binding.email.text} - Contraseña:${binding.password.text}", Toast.LENGTH_LONG)
            //        .show()


            login(it)
        }
    }

    fun login(view: View) {

        val email: String = binding.email.text.toString().trim()
        val password: String = binding.password.text.toString().trim()

        if (email == "example@exmple.com" || password == "1234")
            Snackbar.make(view, R.string.bienvenida, Snackbar.LENGTH_LONG).show()
        else
            Snackbar.make(view, R.string.error_de_login, Snackbar.LENGTH_LONG).show()

    }
}

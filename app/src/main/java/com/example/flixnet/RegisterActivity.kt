package com.example.flixnet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.flixnet.databinding.ActivityMainBinding
import com.example.flixnet.databinding.ActivityRegisterBinding
import com.google.android.material.snackbar.Snackbar

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registerbutton.setOnClickListener{
            register(it)
        }

    }

    fun register(view: View){

        val name : String = binding.name.text.toString().trim()
        val surname : String = binding.surname.text.toString().trim()
        val username : String = binding.username.text.toString().trim()
        val email : String = binding.email.text.toString().trim()
        val password : String = binding.password.text.toString().trim()

        if (email == "example@exmple.com" || password == "1234") {

            val intencion = Intent(this, LoginActivity::class.java)

            startActivity(intencion)
        }
        else {
            Snackbar.make(view, R.string.error_de_registro, Snackbar.LENGTH_LONG).show()

        }
    }
}
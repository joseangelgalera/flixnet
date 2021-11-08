package com.example.flixnet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.flixnet.databinding.ActivityLoginBinding
import com.example.flixnet.objetos.Usuario
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

        binding.registerbutton.setOnClickListener{
            register(it)
        }
    }

    fun login(view: View) {

        val email: String = binding.email.text.toString().trim()
        val password: String = binding.password.text.toString().trim()

        if (email == "example@exmple.com" || password == "1234") {

            //val usuario = Usuario("Laura Lerida", "example@exmple.com", 20 )


            val intencion = Intent(this, MainActivity::class.java)


            val bundle = Bundle()
            bundle.putString("nombre", "Laura Lerida")
            bundle.putInt("edad", 20)

            intencion.putExtra("usuario", bundle)

            startActivity(intencion)
        }
        else
            Snackbar.make(view, R.string.error_de_login, Snackbar.LENGTH_LONG).show()

    }

    fun register(view: View){
        val intencion = Intent(this, RegisterActivity::class.java)

        startActivity(intencion)
    }
}

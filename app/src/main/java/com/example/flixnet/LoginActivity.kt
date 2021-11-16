package com.example.flixnet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import com.example.flixnet.databinding.ActivityLoginBinding
import com.example.flixnet.objetos.Usuario
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth

    private val respuestaRegistro = registerForActivityResult(StartActivityForResult()) {
        /*
        La lambda contiene la lógica que se ejecutará cuando la actividad
        registro responda
        */
        if (it.resultCode == RESULT_OK) {
            val texto = it.data?.extras?.getString("datos")
            Toast.makeText(this, "REGISTRO COMPLETADO", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "REGISTRO CANCELADO", Toast.LENGTH_LONG).show()
        }

    }


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

        binding.registerbutton.setOnClickListener {
            register(it)
        }

        auth = Firebase.auth
    }

    fun login(view: View) {

        val email: String = binding.email.text.toString().trim()
        val password: String = binding.password.text.toString().trim()

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {

                if (it.isSuccessful) {
                    //Snackbar.make(view, R.string.msg_bienvenida, Snackbar.LENGTH_LONG).show()

                    //Emulamos acceder a una base de datos
                    val usuario = Usuario("Laura Lérida", "email@email.com", 20)

                    //Expresamos la intencion de iniciar la actividad MainActivity
                    // que esta definida por la clase MainActivity::class.java
                    val intencion = Intent(this, MainActivity::class.java)

                    intencion.putExtra("_usuario", usuario)

                    // Almacenamos información dentro de la intención
                    //intencion.putExtra("nombre", "Laura Lérida")
                    //intencion.putExtra("edad", 20)

                    //val bundle = Bundle()
                    //bundle.putString("nombre", "Laura Lérida")
                    //bundle.putInt("edad", 20)

                    // asocio el diccionario a la intención
                    //intencion.putExtra("_usuario", bundle)

                    // Iniciamos la intención
                    startActivity(intencion)

                } else {
                    // Seha producido un error y mostramos un mensaje notificandolo
                    Snackbar.make(view, R.string.error_de_login, Snackbar.LENGTH_LONG,)
                        .show()
                }
            }
    }
    fun register(view: View) {
        val intencion = Intent(this, RegisterActivity::class.java)

        respuestaRegistro.launch(intencion)
    }
}

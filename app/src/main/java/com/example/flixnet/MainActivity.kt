package com.example.flixnet

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.example.flixnet.databinding.ActivityLoginBinding
import com.example.flixnet.databinding.ActivityMainBinding
import com.example.flixnet.objetos.Usuario
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth

    @SuppressLint("StringFormatInvalid")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        registerForContextMenu(binding.bienvenida)

        auth = Firebase.auth

        //Recuperamos información almacenada con putextra en la intencion
        //val nombre = intent.extras?.get("nombre")
        val usuario: Usuario = intent.extras?.getSerializable("_usuario") as Usuario

        // recuperamos informacion almacenada en un bundle en la intencion
        val bundle = intent.extras?.getBundle("_usuario")
        val nombre = bundle?.getString("_nombre")

        with(binding.bienvenida) {
            text = resources.getString(R.string.bienvenida, nombre)
        }
        // binding.etiqueta.text = binding.etiqueta.text.toString() + nombre}

        //binding.etiqueta.text = resources.getQuantityString(R.plurals.totalElementos, 23)

        /*
        Lanzamos una intencion implícita (Ejemplo)
        */


        binding.implicita.setOnClickListener {
            // Defininmos la intención implícita
            val intencion = Intent().apply {
                action = Intent.ACTION_SEND
                type = "text/plain" // Tipo de informacion (MIME)
                putExtra(Intent.EXTRA_TEXT, "Te recomiendo que veas LOCKE & KEY")
            }

            // Lanzamos la intencion pero previamente tendremos que comprobar
            // hay algún paquete (app) instalado en el dispositivo
            // capaz de atender la intención.
            if (intencion.resolveActivity(packageManager) != null)
                startActivity(intencion)
        }
    }

    override fun onBackPressed() {

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when(item.itemId) {
            R.id.profilebutton -> {
                Toast.makeText(this, "PERFIL DE USUARIO: PROXIMAMENTE", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.exitbutton -> {
                auth.signOut()
                finish()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }

    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        menuInflater.inflate(R.menu.item_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.edit_menu -> {
                Toast.makeText(this, "HAS PULSADO EN LA OPCION EDITAR", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.delete_menu -> {
                Toast.makeText(this, "HAS PULSADO EN LA OPCION BORRAR", Toast.LENGTH_SHORT).show()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }

         super.onContextItemSelected(item)
    }
}
package com.example.flixnet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.example.flixnet.databinding.ActivityLoginBinding
import com.example.flixnet.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        registerForContextMenu(binding.bienvenida)

        val bundle =intent.extras?.getBundle("usuario")
        val nombre = bundle?.getString("nombre")

        binding.bienvenida.text = "Bienvenido/a ${nombre}"
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
                Toast.makeText(this, "BOTON DE SALIR: PROXIMAMENTE", Toast.LENGTH_SHORT).show()
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
package com.example.miprimeraappalbertom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // Creación del menú
    // https://developer.android.com/guide/topics/ui/menus?hl=es#kotlin
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    // Opciones a pulsar un estado del menú
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.menu_nota -> {
                val intent = Intent(this, NotaAcivity::class.java);
                startActivity(intent)
                true
            }
            R.id.menu_correo -> {
                val intent = Intent(this, CorreoActivity::class.java);
                startActivity(intent)
                true
            }
            R.id.menu_amigo -> {
                val intent = Intent(this, ContactoActivity::class.java);
                startActivity(intent)
                true
            }
            R.id.menu_cita -> {
                val intent = Intent(this, CitaActivity::class.java);
                startActivity(intent)
                true
            }
            R.id.menu_acerca_de -> {
                val intent = Intent(this, AcercaDeActivity::class.java);
                startActivity(intent)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

}
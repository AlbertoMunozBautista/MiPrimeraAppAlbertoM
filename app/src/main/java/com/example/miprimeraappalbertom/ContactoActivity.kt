package com.example.miprimeraappalbertom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import kotlinx.android.synthetic.main.activity_contacto.*

class ContactoActivity : AppCompatActivity() {

    private var nombre: String = ""
    private var correo: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacto)

        val actionbar = supportActionBar
        //Establecer el nombre
        actionbar!!.title = "Agregar Contacto"
        //Establecer el botón de volver atrás
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)


        //Cuando pulsamos el botón de agregar
        ContactoBtnAgregar.setOnClickListener{
            this.nombre = ContactoEtNombre.text.toString()
            this.correo = ContactoEtCorreo.text.toString()

            insertContact(nombre, correo)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun insertContact(nombre: String, correo: String) {
        val intent = Intent(Intent.ACTION_INSERT).apply {
            type = ContactsContract.Contacts.CONTENT_TYPE
            putExtra(ContactsContract.Intents.Insert.NAME, nombre)
            putExtra(ContactsContract.Intents.Insert.EMAIL, correo)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }


    // Para salvar el estado por ejemplo es usando un Bundle en el ciclo de vida
    override fun onSaveInstanceState(outState: Bundle) {
        // Salvamos en un bundle estas variables o estados de la interfaz
        outState.run {
            // Actualizamos los datos o los recogemos de la interfaz

            putString("NOMBRE", nombre)
            putString("CORREO", correo)

        }
        // Siempre se llama a la superclase para salvar as cosas
        super.onSaveInstanceState(outState)
    }

    // Para recuperar el estado al volver al un estado de ciclo de vida de la Interfaz
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        // Recuperamos en un bundle estas variables o estados de la interfaz
        super.onRestoreInstanceState(savedInstanceState)
        // Recuperamos del Bundle
        savedInstanceState.run {

            nombre = getString("NOMBRE").toString()
            correo = getString("CORREO").toString()

        }
    }

}
package com.example.miprimeraappalbertom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
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

}
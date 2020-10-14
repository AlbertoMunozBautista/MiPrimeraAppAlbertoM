package com.example.miprimeraappalbertom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.actions.NoteIntents
import kotlinx.android.synthetic.main.activity_nota.*

class NotaAcivity : AppCompatActivity() {

    private var asunto: String = ""
    private var texto: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nota)

        val actionbar = supportActionBar
        //Establecer el nombre
        actionbar!!.title = "Añadir Nota"
        //Establecer el botón de volver atrás
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        NotaBtnAñadir.setOnClickListener{
            this.asunto = NotaEtAsunto.text.toString()
            this.texto = NotaEtTexto.text.toString()

            createNote(asunto, texto)

        }


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun createNote(asunto: String, texto: String) {
        val intent = Intent(NoteIntents.ACTION_CREATE_NOTE).apply {
            putExtra(NoteIntents.EXTRA_NAME, asunto)
            putExtra(NoteIntents.EXTRA_TEXT, texto)

        }
        //startActivity(intent)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    // Para salvar el estado por ejemplo es usando un Bundle en el ciclo de vida
    override fun onSaveInstanceState(outState: Bundle) {
        // Salvamos en un bundle estas variables o estados de la interfaz
        outState.run {
            // Actualizamos los datos o los recogemos de la interfaz
            putString("ASUNTO", asunto)
            putString("TEXTO", texto)

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

            asunto = getString("ASUNTO").toString()
            texto = getString("TEXTO").toString()

        }
    }



}
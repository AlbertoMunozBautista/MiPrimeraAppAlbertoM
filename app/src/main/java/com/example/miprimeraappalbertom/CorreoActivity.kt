package com.example.miprimeraappalbertom

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_correo.*

class CorreoActivity : AppCompatActivity() {

    private var asunto: String = ""
    private var texto: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_correo)

        val actionbar = supportActionBar
        //Establecer el nombre
        actionbar!!.title = "Mandar Correo"
        //Establecer el botón de volver atrás
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)


        //Cuando pulsamos el botón de enviar
        CorreoBtnEnviar.setOnClickListener{
            this.asunto = CorreoEtAsunto.text.toString()
            this.texto = CorreoEtTexto.text.toString()
            val destinatario = arrayOf(CorreoEtPara.text.toString())

            composeEmail(destinatario, asunto, texto)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    //Función que contiene los intent para enviar el correo
    fun composeEmail(destinatario: Array<String>, asunto: String, texto : String) {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:") // only email apps should handle this
            putExtra(Intent.EXTRA_EMAIL, destinatario)
            putExtra(Intent.EXTRA_SUBJECT, asunto)
            putExtra(Intent.EXTRA_TEXT, texto)
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
package com.example.miprimeraappalbertom

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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


}
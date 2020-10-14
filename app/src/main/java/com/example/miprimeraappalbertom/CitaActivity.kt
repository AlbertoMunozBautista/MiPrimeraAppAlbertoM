package com.example.miprimeraappalbertom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import kotlinx.android.synthetic.main.activity_cita.*


class CitaActivity : AppCompatActivity() {

    private var titulo: String = ""
    private var localizacion: String = ""
    private var fechaIni: Long = 0
    private var fechaFin: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cita)

        val actionbar = supportActionBar
        //Establecer el nombre
        actionbar!!.title = "Agregar Evento"
        //Establecer el botón de volver atrás
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)


        CitaBtnContacto.setOnClickListener{
            this.titulo = CitaEtTitulo.text.toString()
            this.localizacion = CitaEtLocalizacion.text.toString()
            this.fechaIni = (CitaEtFechaIni.text.toString().toLong() -1) * +60*60*1000
            this.fechaFin = (CitaEtFechaFin.text.toString().toLong() - 1) * +60*60*1000

            addEvent(titulo, localizacion, fechaIni, fechaFin)
        }


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun addEvent(titulo: String, localizacion: String, fechaIni: Long, fechaFin: Long) {
        val intent = Intent(Intent.ACTION_INSERT).apply {
            data = CalendarContract.Events.CONTENT_URI
            putExtra(CalendarContract.Events.TITLE, titulo)
            putExtra(CalendarContract.Events.EVENT_LOCATION, localizacion)
            putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, fechaIni)
            putExtra(CalendarContract.EXTRA_EVENT_END_TIME, fechaFin)
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

            putString("TITULO", titulo)
            putString("LOCALIZACION", localizacion)
            putLong("FECHAINI", fechaIni)
            putLong("FECHAFIN", fechaFin)

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

            titulo = getString("TITULO").toString()
            localizacion = getString("LOCALIZACION").toString()
            fechaIni = getLong("FECHAINI")
            fechaFin = getLong("FECHAFIN")

        }
    }

}
package com.example.miprimeraappalbertom

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_acerca_de.*

class AcercaDeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acerca_de)

        val actionbar = supportActionBar
        //Establecer el nombre
        actionbar!!.title = "Acerca De"
        //Establecer el botón de volver atrás
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        AcercaImaGit.setOnClickListener{
            (entrarEnlace("https://github.com/AlbertoMunozBautista"))
        }

        AcercaImaTwitter.setOnClickListener{
            (entrarEnlace("https://twitter.com/albertombau?s=21"))
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun entrarEnlace(enlace: String){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(enlace))
        startActivity(intent)
    }



}
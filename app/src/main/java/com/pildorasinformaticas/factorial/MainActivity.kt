package com.pildorasinformaticas.factorial

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val numero: EditText = findViewById(R.id.editTextText)
        val boton: Button = findViewById(R.id.button)
        val texto: TextView = findViewById(R.id.textView)

        //Guardamos número

        boton.setOnClickListener() {
            val numeroIntroducido = numero.text.toString().toIntOrNull()
            if (numeroIntroducido != null) {

                var resultado: Int = 1

                for (i in 1..numeroIntroducido) {

                    resultado *= i
                }
                texto.text = "$resultado"
            } else {
                texto.text = "Introduce un número válido"
            }
        }
    }
}
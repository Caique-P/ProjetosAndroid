package com.caiqueponjjar.salvarinstancia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import java.math.RoundingMode.valueOf

class MainActivity : AppCompatActivity() {
    private var count = "0"
        // Definindo um setter para receber o numero salvo
        set(value) {
        field = value
            findViewById<TextView>(R.id.textNumero).text = value.toString()
    }

    // Criando a view -------
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adicionar = findViewById<Button>(R.id.Adicionar)
        findViewById<TextView>(R.id.textNumero).text = count
        adicionar.setOnClickListener{
            count = (count.toInt() + 1).toString();
        }
        }
    // Restaurando o numero ja salvo
        override fun onRestoreInstanceState(savedInstanceState: Bundle) {
            super.onRestoreInstanceState(savedInstanceState)
            count = savedInstanceState.getString("Numeros").toString()

        }
    // Salvando o numero
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

            //val text = findViewById<TextView>(R.id.textNumero).text.toString()
            outState.putString("Numeros", count)
    }
}
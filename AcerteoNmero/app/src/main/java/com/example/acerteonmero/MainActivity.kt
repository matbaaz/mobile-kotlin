package com.example.acerteonmero

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var sortedNumber = (1..100).random()
    var tries = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        println("SORTED NUMBER $sortedNumber")
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun guess(vew: View){
        val imput = findViewById<EditText>(R.id.editTextImput)
        val output = findViewById<TextView>(R.id.textViewOutput)
        var tip = "Valor é maior, seu burro."

        if(imput.length() == 0){
            Toast.makeText(this,"Manda um número ai pai.",Toast.LENGTH_SHORT).show()
            output.text = ""
        } else {
            val inputNumber = imput.text.toString().toInt()
            tries++


            if (inputNumber > sortedNumber) {
                tip = "Valor é menor, otário"
            } else if (inputNumber == sortedNumber) {
                tip = "Parabens porra, finalmente!\n\nTentativas: $tries"
            }
            output.text = tip
        }
    }
}
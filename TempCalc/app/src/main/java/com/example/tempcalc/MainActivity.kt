package com.example.tempcalc

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
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
    }

    fun CalculaTemp(view: View){
        val toCelcius = findViewById<RadioButton>(R.id.radioButtonCelcius)
        val imput = findViewById<EditText>(R.id.editTextNumberDecimal)
        var output = findViewById<TextView>(R.id.textViewOutput)

        if (imput.length()==0){
            Toast.makeText(this,"Adicione um valor para a conversão",Toast.LENGTH_SHORT).show()
            output.text = ""
        } else {
            if (toCelcius.isChecked) {
                var temperatura = (imput.text.toString().toFloat() - 32) *5/9
                output.text = "$temperatura graus Celsius"
            } else{
                var temperature = imput.text.toString().toFloat()*9/5 +32
                output.text = "$temperature graus Farenheit"
            }
        }
    }
}
package com.example.converterdolar

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
    fun converter(view: View){
        val input = findViewById<EditText>(R.id.editTextNumberDecimal)
        val output = findViewById<TextView>(R.id.textViewOutput)
        if (input.length() == 0){
            Toast.makeText(this, "Manda um valor em dolares ai manoo!!", Toast.LENGTH_SHORT).show()
            output.text = ""
        } else {
            val dolar: Double = input.text.toString().toDouble()
            val real = dolar * 5.5
            output.text = "$real reais"
        }

    }
}
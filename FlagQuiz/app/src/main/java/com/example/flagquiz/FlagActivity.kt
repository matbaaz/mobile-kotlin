package com.example.flagquiz

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FlagActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_flag)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val bundle = intent.extras
        val flags = listOf(
            R.drawable.flag_hong,
            R.drawable.flag_malta,
            R.drawable.flag_nauru,
            R.drawable.flag_samoa,
            R.drawable.flag_cayman,
            R.drawable.flag_guinea,
            R.drawable.flag_vietnam,
            R.drawable.flag_antartica,
            R.drawable.flag_barbados,
            R.drawable.flag_cayman
        )
        val imgFlag: ImageView = findViewById<ImageView>(R.id.flagImage)
        val rndFlag = flags.random()
        imgFlag.setImageResource(rndFlag)

        fun testeFlag(view: View){
            val pais = findViewById<EditText>(R.id.editTextPais)
            val nomeFlag = pais.text.toString()

            if (nomeFlag.uppercase() == rndFlag.toString().substring(15).uppercase()){
                val teste = findViewById<TextView>(R.id.textViewbandeira)
                teste.text = "teste"
            }

        }
    }

}
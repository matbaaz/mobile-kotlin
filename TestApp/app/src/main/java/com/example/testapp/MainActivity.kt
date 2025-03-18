package com.example.testapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.View
import android.widget.TextView

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
    fun quote(view: View){
        val quote = arrayOf(
            "No fim do jogo, o peão e o rei vão pra mesma caixa",
            "Se uma janela se fechar, arrombe a porta",
            "Do chçao não passa",
            "Cair, beber, levantar e trampar",
            "Não morra, as pessoas te esquecerão",
            "Seu legado vai ser realmente trabalhar?",
            "Durma enquanto eles trabalham, verdadeiras fortunas são construidas por escreavos",
            "8",
            "9",
            "0"
        )
        val txtview = findViewById<TextView>(R.id.textViewOutput)
        val index = (0..9).random()
        txtview.text = quote[index]
    }
}
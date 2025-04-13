package com.example.alunonota

import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class NotaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_nota)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bundle = intent.extras

        if(bundle != null){
            val data = if (Build.VERSION.SDK_INT >=  Build.VERSION_CODES.TIRAMISU){
                bundle.getParcelable("aluno", Aluno::class.java)
            } else{
                bundle.getParcelable("aluno")
            }
            val presenca = data?.presenca
            val nomeMostra = data?.nome
            val mediaMostra = data?.media

            val nome = findViewById<TextView>(R.id.textViewnome)
            val media = findViewById<TextView>(R.id.textViewmedia)
            val mensagem = findViewById<TextView>(R.id.textViewMensagem)



            var msg = ""

            if(mediaMostra!! < 4.0){
                msg = "Reprovado por nota"
            } else if (presenca!! < 75){
                msg = "Reprovado por presença"
            } else if(mediaMostra!! < 7.0){
                msg = "Final"
            } else {
                msg = "Aprovado"
            }

            nome.text = nomeMostra
            media.text = mediaMostra.toString()
            mensagem.text = msg
        }


    }
}
package com.example.alunonota

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
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
    fun calculaNota(view: View) {
        val nota1 = findViewById<EditText>(R.id.editNota1)
        val nota2 = findViewById<EditText>(R.id.EditNota2)
        val nome = findViewById<EditText>(R.id.editTextNome)
        val presenca = findViewById<EditText>(R.id.editPresenca)

        if (nota1.length() == 0 || nota2.length() == 0 || nome.length() == 0 || presenca.length() == 0) {
            Toast.makeText(this, "Todos os campos devem estar presnchidos", Toast.LENGTH_LONG).show()
        }
         else if (nota1.text.toString().toDouble() > 10 || nota2.text.toString().toDouble() > 10) {
             Toast.makeText(this, "Nota não pode ser maior que 10", Toast.LENGTH_LONG).show()
         } else {
            var notaFinal = (nota1.text.toString().toDouble() + nota2.text.toString().toDouble()) / 2
            var nomeAluno = nome.text.toString()
            var tantoPresenca = presenca.text.toString().toInt()

            val aluno = Aluno(nomeAluno, notaFinal, tantoPresenca)

            var intent = Intent(this, NotaActivity::class.java)
            intent.putExtra("aluno", aluno)
            startActivity(intent)
        }
    }
}
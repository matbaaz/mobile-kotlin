package com.example.standardlist

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val ingredientes = findViewById<TextView>(R.id.textViewIngredientes)
        val preparo = findViewById<TextView>(R.id.textViewPreparo)
        val drink = findViewById<TextView>(R.id.textViewNomeDrink)

        var nome = intent.getStringExtra("drink")

        nome?.let {
            var preparar = ""
            var ingred = ""
            when (it) {
                "Quentão" -> {
                    ingred =
                        "1 Garrafa de cachaça\n600ml de água\n1/2kg de açucar\nCasca de 2 laranjas\nCasca de 1 limão\n50g de Gengibre em pedaços" +
                                "\nCravo da india a gosto\nCanela de pau a gosto\n1 maçã cortada em pedacinhos "
                    preparar =
                        "1. Colocar em uma panela grande o açucar, as cascas de laranja o limão e o gengibre, o cravo e a canela\n 2. Quando o açucar" +
                                " estiver derretendo, colocar a cachaça e a agua, deixando cozinhar por 20 a 25 minutos em fogo médio\n3. " +
                                "Filtre, e após coloque a maçã picadinha\n4. Manter no fogo após o preparo"
                }

                "Drink dos deuses" -> {
                    ingred =
                        "1 vidro (100ml) de leite de coco\n1 copo (100ml) de suco de maracujá\n1 copo (100ml) de groselha\n" +
                                "cerca de 1 lata de leite condensado\n1 copo (100ml) de cachaça\nGelo picado"
                    preparar =
                        "1. Bater os 5 primeiros ingredientes no liquidificador e acrescentar gelo na hora de servir"
                }
                "Batida de Sonho de valsa" -> {
                    ingred = "3 bomboms de sonho de valsa\n1 lata de leite condensado\n1/2 garrafa de pinga\n1 latinha de guaraná  "
                    preparar = "1. Bater tudo no liquidificador, ficando os chocolates crocantes por cima\n Servir gelado"
                }
            }

            preparo.text = preparar
            ingredientes . text = ingred
            drink.text = it


        }
    }

}
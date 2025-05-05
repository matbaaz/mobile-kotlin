package com.example.heroeslist

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MasterActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_master)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        recyclerView = findViewById(R.id.heroesRV)
        recyclerView.adapter = HeroAdapter(createHeroes())
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
    private fun createHeroes(): List<Hero>{
        return listOf(
            Hero("Batman","DC Comics",R.drawable.batman),
            Hero("Hulk","Marvel",R.drawable.hulk),
            Hero("Flash","DC Comics",R.drawable.flash),
            Hero("Iron Man","Marvel",R.drawable.ironman),
            Hero("Superman","DC Comics",R.drawable.superman),
            Hero("Dr. Strange","Marvel",R.drawable.drstrange)
        )
    }
}
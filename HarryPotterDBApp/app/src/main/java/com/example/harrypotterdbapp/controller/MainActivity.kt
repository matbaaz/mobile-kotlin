package com.example.harrypotterdbapp.controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.harrypotterdbapp.R
import com.example.harrypotterdbapp.data.dao.HPCharDAO
import com.example.harrypotterdbapp.model.HPChar

class MainActivity : AppCompatActivity() {

    private lateinit var hpCharDAO: HPCharDAO
    private lateinit var listView: ListView
    private lateinit var emptyTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.lvChars)
        emptyTextView = findViewById(R.id.tvEmpty)
        hpCharDAO = HPCharDAO(this)

        listAllChars()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        listView.setOnItemClickListener { parent, view, position, id ->
            val selectedChar = parent.getItemAtPosition(position) as HPChar
            val intent = Intent(this, NewHPCharActivity::class.java).apply{
                putExtra("charID", selectedChar.id)
            }
            startActivity(intent)
        }


    }
    private fun listAllChars() {
        val hpChars = hpCharDAO.getAllCharacters()
        if (hpChars.isEmpty()) {
            listView.visibility = ListView.GONE
            emptyTextView.visibility = TextView.VISIBLE
        } else {
            listView.visibility = ListView.VISIBLE
            emptyTextView.visibility = TextView.GONE
            val adapter: ArrayAdapter<HPChar> = ArrayAdapter(
                this, android.R.layout.simple_list_item_1, hpChars
            )
            listView.adapter = adapter
        }
    }

    fun newChar(view: View) {
        val intent = Intent(this, NewHPCharActivity::class.java)
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        listAllChars()
    }
}
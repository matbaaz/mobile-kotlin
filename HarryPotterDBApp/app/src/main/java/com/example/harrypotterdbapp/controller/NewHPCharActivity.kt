package com.example.harrypotterdbapp.controller

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.harrypotterdbapp.R
import com.example.harrypotterdbapp.data.dao.HPCharDAO
import com.example.harrypotterdbapp.model.HPChar

class NewHPCharActivity : AppCompatActivity() {

    private lateinit var hpCharDao: HPCharDAO
    private var hpCharID: Int = 0
    private lateinit var etName: EditText
    private lateinit var etHouse: EditText
    private lateinit var etAncestry: EditText
    private lateinit var btnDelete: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_new_hpchar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
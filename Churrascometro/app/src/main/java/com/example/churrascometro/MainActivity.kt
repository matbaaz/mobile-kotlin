package com.example.churrascometro

import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
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
        val sbHomen = findViewById<SeekBar>(R.id.seekBarHomen)
        var sbMulher = findViewById<SeekBar>(R.id.seekBarMulher)

        var homenQtt = findViewById<TextView>(R.id.textViewQtdHome)
        var mulherQtt = findViewById<TextView>(R.id.textViewQtdMul)

        sbHomen.setOnSeekBarChangeListener(object:  SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                homenQtt.text = sbHomen.progress.toString()
                calculate(sbHomen.progress, sbMulher.progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })

        sbMulher.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                mulherQtt.text = sbMulher.progress.toString()
                calculate(sbHomen.progress,sbMulher.progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })

    }
    fun calculate(home: Int,mulher: Int){
        var outputcarne = findViewById<TextView>(R.id.textViewOutputCarne)
        var outputlinguica = findViewById<TextView>(R.id.textViewOutputLinguica)

        var carne : Double = home*300.0 + mulher*250.0
        var linguica : Double = home*250.0 + mulher*150.0

        outputcarne.text = (carne/1000).toString() + " Kg"
        outputlinguica.text = (linguica/1000).toString() + " Kg"
    }
}
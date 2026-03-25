package com.example.checkoutcal

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val llHistory = findViewById<LinearLayout>(R.id.llHistory)
        val btnBack = findViewById<Button>(R.id.btnBack)

        // dohvati povijest iz IntentExtras
        val history = intent.getStringArrayListExtra("history") ?: arrayListOf()

        if (history.isEmpty()) {
            val tv = TextView(this)
            tv.text = "Još nema checkoutova!"
            tv.textSize = 16f
            tv.setTextColor(0xFFFFFFFF.toInt())
            llHistory.addView(tv)
        } else {
            history.forEach { item ->
                val tv = TextView(this)
                tv.text = item
                tv.textSize = 16f
                tv.setTextColor(0xFFFFFFFF.toInt())
                tv.setPadding(0, 12, 0, 12)
                llHistory.addView(tv)
            }
        }

        btnBack.setOnClickListener {
            finish() // zatvori ovaj Activity i vrati se nazad
        }
    }
}
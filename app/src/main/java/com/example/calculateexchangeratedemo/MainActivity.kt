package com.example.calculateexchangeratedemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val switchBtn = findViewById<Button>(R.id.switchPageButton)

        switchBtn.setOnClickListener {

            val intent = Intent(this, CalculateExchangeRatePage::class.java)
            startActivity(intent)

        }
    }
}
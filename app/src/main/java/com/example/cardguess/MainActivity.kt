package com.example.cardguess

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startBtn : TextView = findViewById(R.id.startTextView)

        startBtn.setOnClickListener() {
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }
    }
}
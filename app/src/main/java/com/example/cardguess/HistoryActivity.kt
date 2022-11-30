package com.example.cardguess

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HistoryActivity : AppCompatActivity() {

    lateinit var backButton: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val cardList = CardDeck.pastCards
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        backButton = findViewById(R.id.backView)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = DrawHistoryAdapter(this, cardList)

        recyclerView.adapter = adapter

        backButton.setOnClickListener {

            finish()

        }
    }

}
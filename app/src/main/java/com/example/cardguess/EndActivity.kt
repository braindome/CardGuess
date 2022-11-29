package com.example.cardguess

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class EndActivity : AppCompatActivity() {

    lateinit var score : TextView
    lateinit var replay : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)

        score = findViewById(R.id.scoreValue)
        replay = findViewById(R.id.replayButtonView)

        score.text = intent.getIntExtra("currentScore", 42).toString()


        //Replay button restarts the game and resets the score.
        replay.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
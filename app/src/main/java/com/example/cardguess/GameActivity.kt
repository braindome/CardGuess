package com.example.cardguess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class GameActivity : AppCompatActivity() {

    lateinit var score : TextView
    lateinit var lower : TextView
    lateinit var higher : TextView
    lateinit var quit : TextView
    lateinit var cardPicture : ImageView

    val deck : CardDeck = CardDeck()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

    }



    fun play() {
        lower = findViewById(R.id.minusButtonView)
        higher = findViewById(R.id.plusButtonView)
        score = findViewById(R.id.streakTextView)
        quit = findViewById(R.id.quitButtonView)
        cardPicture = findViewById(R.id.randomCardImgView)
        score = findViewById(R.id.streakTextView)

        lower.setOnClickListener() {
            //TODO: card values and maths
            val cardValue : Int = 0
            var currentScore = score.text.toString().toInt()
            if (deck.currentCard.value > cardValue) {
                currentScore++
                score.text = currentScore.toString()
            }

        }

        higher.setOnClickListener() {
            //TODO: card values and maths
            val cardValue : Int = 0
            var currentScore = score.text.toString().toInt()
            if (deck.currentCard.value < cardValue) {
                currentScore++
                score.text = currentScore.toString()

            }

        }
    }
}
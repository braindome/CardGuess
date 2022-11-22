package com.example.cardguess

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class GameActivity : AppCompatActivity() {

    lateinit var score : TextView
    lateinit var lower : TextView
    lateinit var higher : TextView
    lateinit var quit : TextView
    lateinit var cardPicture : ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)


        lower = findViewById(R.id.minusButtonView)
        higher = findViewById(R.id.plusButtonView)
        score = findViewById(R.id.streakTextView)
        quit = findViewById(R.id.quitButtonView)
        cardPicture = findViewById(R.id.randomCardImgView)
        score = findViewById(R.id.streakTextView)

        play()

    }


    //TODO Button functions and recalling to GameActivity. Quit button to EndActivity.
    private fun play() {

        //var currentScore = score.text.toString().toInt()
        var currentScore = 0
        val deck = CardDeck()
        val startingCard = deck.randomCard()
        val nextCard = deck.randomCard()
        Log.d("!!!", startingCard.value.toString())

        cardPicture.setImageResource(startingCard.image)

        lower.setOnClickListener {

            if (nextCard.value < startingCard.value) {
                currentScore++
                score.text = currentScore.toString()
            } else currentScore--
        }

        higher.setOnClickListener {

            if (nextCard.value > startingCard.value) {
                currentScore++
                score.text = currentScore.toString()
            } else currentScore--
        }
    }
}
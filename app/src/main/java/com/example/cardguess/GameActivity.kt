package com.example.cardguess

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

//TODO Comments and descriptions

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


    //TODO Layout rework, make it prettier.
    fun play() {

        val deck = CardDeck()
        var currentScore = 0
        val startingCard = deck.randomCard()
        var nextCard = deck.randomCard()


        Log.d("!!!", startingCard.value.toString())

        cardPicture.setImageResource(startingCard.image)

        lower.setOnClickListener {
            cardPicture.setImageResource(nextCard.image)
            if (nextCard.value < startingCard.value) {
                currentScore++
                score.text = currentScore.toString()
            } else {
                currentScore--
                score.text = currentScore.toString()
            }
            nextCard = deck.drawCard()
        }

        higher.setOnClickListener {
            cardPicture.setImageResource(nextCard.image)
            if (nextCard.value > startingCard.value) {
                currentScore++
                score.text = currentScore.toString()
            } else {
                currentScore--
                score.text = currentScore.toString()
            }
            nextCard = deck.drawCard()
        }

        quit.setOnClickListener {
            val intent = Intent(this, EndActivity::class.java)
            intent.putExtra("currentScore", currentScore)
            startActivity(intent)
        }

    }

}
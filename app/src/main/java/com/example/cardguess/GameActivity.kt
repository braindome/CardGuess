package com.example.cardguess

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class GameActivity : AppCompatActivity() {

    lateinit var score : TextView
    lateinit var lower : TextView
    lateinit var higher : TextView
    lateinit var quit : TextView
    lateinit var cardPicture : ImageView
    lateinit var scoreText : String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)


        lower = findViewById(R.id.minusButtonView)
        higher = findViewById(R.id.plusButtonView)
        score = findViewById(R.id.streakTextView)
        quit = findViewById(R.id.quitButtonView)
        cardPicture = findViewById(R.id.randomCardImgView)
        score = findViewById(R.id.streakTextView)
        scoreText = getString(R.string.current_score)


        play()

    }


    //TODO Layout rework, make it prettier.
    @SuppressLint("SetTextI18n")
    fun play() {

        val deck = CardDeck()
        var currentScore = 0
        val startingCard = deck.randomCard()
        var nextCard = deck.randomCard()


        cardPicture.setImageResource(startingCard.image)

        lower.setOnClickListener {

            cardPicture.setImageResource(nextCard.image)

            if (nextCard.value < startingCard.value) {
                currentScore++
                score.text = "$scoreText $currentScore"
            } else {
                currentScore--
                score.text = "$scoreText $currentScore"
            }
            nextCard = deck.drawCard()
        }

        higher.setOnClickListener {

            cardPicture.setImageResource(nextCard.image)

            if (nextCard.value > startingCard.value) {
                currentScore++
                score.text = "$scoreText $currentScore"
            } else {
                currentScore--
                score.text = "$scoreText $currentScore"
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
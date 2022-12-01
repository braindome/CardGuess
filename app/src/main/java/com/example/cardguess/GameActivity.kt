package com.example.cardguess

import android.annotation.SuppressLint
import android.content.Intent
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
    lateinit var scoreText : String
    lateinit var historyButton : TextView
    lateinit var lifeOne : ImageView
    lateinit var lifeTwo : ImageView
    lateinit var lifeThree : ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)


        lower = findViewById(R.id.minusButtonView)
        higher = findViewById(R.id.plusButtonView)
        score = findViewById(R.id.streakTextView)
        quit = findViewById(R.id.quitButtonView)
        cardPicture = findViewById(R.id.randomCardImgView)
        score = findViewById(R.id.streakTextView)
        historyButton = findViewById(R.id.historyView)
        lifeOne = findViewById(R.id.lifeIcon1)
        lifeTwo = findViewById(R.id.lifeIcon2)
        lifeThree = findViewById(R.id.lifeIcon3)
        scoreText = getString(R.string.current_score)

        play()

    }


    //Play loop.
    @SuppressLint("SetTextI18n")
    fun play() {

        //Initializes deck and score variables, picks two random cards to use as start and following.
        val deck = CardDeck
        var lives = 3
        var currentScore = 0
        var startingCard = deck.drawCard()
        var nextCard = deck.drawCard()

        //Starts with a random card with corresponding picture.
        cardPicture.setImageResource(startingCard.image)

        lower.setOnClickListener {

            cardPicture.setImageResource(nextCard.image)

            if (nextCard.value < startingCard.value) {
                currentScore += 1
                score.text = "$scoreText $currentScore"
            } else {
                currentScore -= 1
                score.text = "$scoreText $currentScore"
            }

            if (currentScore == 0) {
                lives -= 1
                if (lives == 2) {
                    lifeThree.setImageResource(0)
                } else if (lives == 1) {
                    lifeTwo.setImageResource(0)
                } else if (lives == 0) {
                    lifeOne.setImageResource(0)
                }
                lifeCheck(lives)
            } else if (currentScore == 10) {
                //TODO win message
            }

            CardDeck.pastCards.add(startingCard)
            startingCard = nextCard
            nextCard = deck.drawCard()
            Log.d("!!!", "nextCard value: ${nextCard.value}")
            Log.d("!!!", "startingCard value: ${startingCard.value}")
        }

        higher.setOnClickListener {

            cardPicture.setImageResource(nextCard.image)

            if (nextCard.value > startingCard.value) {
                currentScore += 1
                score.text = "$scoreText $currentScore"
            } else {
                currentScore -= 1
                score.text = "$scoreText $currentScore"
            }

            if (currentScore == 0) {
                lives -= 1
                if (lives == 2) {
                    lifeThree.setImageResource(0)
                } else if (lives == 1) {
                    lifeTwo.setImageResource(0)
                } else if (lives == 0) {
                    lifeOne.setImageResource(0)
                }
                lifeCheck(lives)
            } else if (currentScore == 10) {
                //TODO win message
            }

            CardDeck.pastCards.add(startingCard)
            startingCard = nextCard
            nextCard = deck.drawCard()
            Log.d("!!!", "nextCard value: ${nextCard.value}")
            Log.d("!!!", "startingCard value: ${startingCard.value}")
        }
        

        quit.setOnClickListener {
            val intent = Intent(this, EndActivity::class.java)
            intent.putExtra("currentScore", currentScore)
            startActivity(intent)
        }

        historyButton.setOnClickListener {
            val intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
        }

    }

    fun lifeCheck(life : Int) {
        if ( life == 0 ) {
            val intent = Intent(this, EndActivity::class.java)
            startActivity(intent)
        }
    }


}


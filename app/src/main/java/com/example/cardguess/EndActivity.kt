package com.example.cardguess

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class EndActivity : AppCompatActivity() {

    lateinit var score : TextView
    lateinit var replay : TextView
    lateinit var finalScoreMsg : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)

        score = findViewById(R.id.scoreValue)
        replay = findViewById(R.id.replayButtonView)
        finalScoreMsg = findViewById(R.id.finalScoreView)

        score.text = intent.getIntExtra("currentScore", 42).toString()
        var resultWin = intent.getStringExtra("win")
        var resultLose = intent.getStringExtra("lose")



        //Replay button restarts the game and resets the score.
        replay.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }



    }

    fun addWinFragment(view : View) {
        val winFragment = WinFragment()
        val transaction = supportFragmentManager.beginTransaction()

        transaction.add(R.id.container, winFragment, "winFragment")
        transaction.commit()

    }

    fun addLoseFragment(view: View) {
        val loseFragment = LoseFragment()
        val transaction = supportFragmentManager.beginTransaction()

        transaction.add(R.id.container, loseFragment, "loseFragment")
        transaction.commit()

    }

    fun addQuitFragment(view: View) {
        val quitFragment = QuitFragment()
        val transaction = supportFragmentManager.beginTransaction()

        transaction.add(R.id.container, quitFragment, "quitFragment")
        transaction.commit()

    }
}
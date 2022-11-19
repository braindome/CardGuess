package com.example.cardguess

import android.widget.ImageView

class CardDeck {

    private val deck  = mutableListOf(Card(2, R.drawable.clubs2), Card(3, R.drawable.clubs3), Card(4, R.drawable.clubs4), Card(5, R.drawable.clubs5), Card(6, R.drawable.clubs6), Card(7, R.drawable.clubs7), Card(8, R.drawable.clubs8), Card(9, R.drawable.clubs9), Card(10, R.drawable.clubs10), Card(11, R.drawable.clubs11), Card(12, R.drawable.clubs12), Card(13, R.drawable.clubs13), Card(14, R.drawable.clubs14))
    lateinit var currentCard : Card
    private val random : kotlin.random.Random = kotlin.random.Random

    fun randomCard(image : ImageView) : Card {
        currentCard = deck[random.nextInt(deck.size)]
        image.setImageResource(currentCard.image)
        return currentCard
    }

//    fun initializeDeck() {
//        val valueList = listOf(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14)
//        val drawable : String = "R.drawable.clubs"
//    }


}
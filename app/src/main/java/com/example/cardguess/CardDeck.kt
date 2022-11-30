package com.example.cardguess

import kotlin.random.Random

object CardDeck {

    val deck = mutableListOf<Card>()
    var pastCards = mutableListOf<Card>()

    init {
        //Initializes and shuffles the deck.
        initDeck()
        deck.shuffle()
    }

    //Creates the card deck.
    fun initDeck() {

        deck.add(Card(2, R.drawable.clubs2))
        deck.add(Card(3, R.drawable.clubs3))
        deck.add(Card(4, R.drawable.clubs4))
        deck.add(Card(5, R.drawable.clubs5))
        deck.add(Card(6, R.drawable.clubs6))
        deck.add(Card(7, R.drawable.clubs7))
        deck.add(Card(8, R.drawable.clubs8))
        deck.add(Card(9, R.drawable.clubs9))
        deck.add(Card(10, R.drawable.clubs10))
        deck.add(Card(11, R.drawable.clubs11))
        deck.add(Card(12, R.drawable.clubs12))
        deck.add(Card(13, R.drawable.clubs13))
        deck.add(Card(14, R.drawable.clubs14))
        deck.add(Card(2, R.drawable.diamonds2))
        deck.add(Card(3, R.drawable.diamonds3))
        deck.add(Card(4, R.drawable.diamonds4))
        deck.add(Card(5, R.drawable.diamonds5))
        deck.add(Card(6, R.drawable.diamonds6))
        deck.add(Card(7, R.drawable.diamonds7))
        deck.add(Card(8, R.drawable.diamonds8))
        deck.add(Card(9, R.drawable.diamonds9))
        deck.add(Card(10, R.drawable.diamonds10))
        deck.add(Card(11, R.drawable.diamonds11))
        deck.add(Card(12, R.drawable.diamonds12))
        deck.add(Card(13, R.drawable.diamonds13))
        deck.add(Card(14, R.drawable.diamonds14))
        deck.add(Card(2, R.drawable.hearts2))
        deck.add(Card(3, R.drawable.hearts3))
        deck.add(Card(4, R.drawable.hearts4))
        deck.add(Card(5, R.drawable.hearts5))
        deck.add(Card(6, R.drawable.hearts6))
        deck.add(Card(7, R.drawable.hearts7))
        deck.add(Card(8, R.drawable.hearts8))
        deck.add(Card(9, R.drawable.hearts9))
        deck.add(Card(10, R.drawable.hearts10))
        deck.add(Card(11, R.drawable.hearts11))
        deck.add(Card(12, R.drawable.hearts12))
        deck.add(Card(13, R.drawable.hearts13))
        deck.add(Card(14, R.drawable.hearts14))
        deck.add(Card(2, R.drawable.spades2))
        deck.add(Card(3, R.drawable.spades3))
        deck.add(Card(4, R.drawable.spades4))
        deck.add(Card(5, R.drawable.spades5))
        deck.add(Card(6, R.drawable.spades6))
        deck.add(Card(7, R.drawable.spades7))
        deck.add(Card(8, R.drawable.spades8))
        deck.add(Card(9, R.drawable.spades9))
        deck.add(Card(10, R.drawable.spades10))
        deck.add(Card(11, R.drawable.spades11))
        deck.add(Card(12, R.drawable.spades12))
        deck.add(Card(13, R.drawable.spades13))
        deck.add(Card(14, R.drawable.spades14))

    }

    //Picks a random card.
    fun randomCard(): Card {
        return deck[Random.nextInt(deck.size)]
    }

    //Shuffles deck and returns a random card.
    fun drawCard() : Card {
        deck.shuffle()
        return randomCard()
    }

    fun addToHistory(card : Card) {
        pastCards.add(card)
    }


}
package com.example.cardguess

class CardDeck (card : Card) {

    private val deck  = mutableListOf<Card>()
    lateinit var currentCard : Card

    fun initializeDeck() {
        //val card = Card("Clubs", 2, R.drawable.two_clubs)
        val suitList = listOf("Clubs", "Diamonds", "Hearts", "Spades")
        val valueList = listOf(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14)

        for (i in suitList) {
            for (j in valueList) {
                deck.add(Card(i, j))
                print(deck)
            }
        }

    }


}
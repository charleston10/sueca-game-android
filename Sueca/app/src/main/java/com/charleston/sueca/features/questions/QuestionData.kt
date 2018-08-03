package com.charleston.sueca.features.questions

data class QuestionData(
        var description: String,
        var explanation: String = "",
        var cards: ArrayList<Int> = arrayListOf()
) {
    fun getCardRandom(): Int {
        cards.shuffle()
        return cards[0]
    }
}
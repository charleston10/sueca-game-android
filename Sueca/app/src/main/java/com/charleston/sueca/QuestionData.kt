package com.charleston.sueca

data class QuestionData(
        var description: String,
        var explanation: String = "",
        var cards: ArrayList<Int> = arrayListOf()
)
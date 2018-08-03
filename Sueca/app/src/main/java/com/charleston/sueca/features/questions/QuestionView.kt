package com.charleston.sueca.features.questions

import android.support.annotation.IdRes

interface QuestionView {
    fun showQuestion(questionData: QuestionData, @IdRes card: Int)
}
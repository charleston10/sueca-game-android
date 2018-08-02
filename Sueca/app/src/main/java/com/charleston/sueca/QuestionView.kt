package com.charleston.sueca

import android.support.annotation.IdRes

interface QuestionView {
    fun showQuestion(questionData: QuestionData, @IdRes card: Int)
}
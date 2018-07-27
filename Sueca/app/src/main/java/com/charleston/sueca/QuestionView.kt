package com.charleston.sueca

interface QuestionView {
    fun showLoading()
    fun hideLoading()
    fun showQuestion(questionData: QuestionData)
}
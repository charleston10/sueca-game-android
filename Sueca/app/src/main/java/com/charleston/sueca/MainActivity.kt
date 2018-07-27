package com.charleston.sueca

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), QuestionView {

    private val questionPresenter by lazy { QuestionPresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun showQuestion(questionData: QuestionData) {
    }
}

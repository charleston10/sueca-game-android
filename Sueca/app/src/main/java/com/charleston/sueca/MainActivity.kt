package com.charleston.sueca

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), QuestionView {

    private val questionPresenter by lazy { QuestionPresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindElements()
    }

    override fun showLoading() {
        question_btn_play.hide()
        question_container.hide()
    }

    override fun hideLoading() {
        question_container.show()
        question_btn_play.show()
    }

    override fun showQuestion(questionData: QuestionData) {
        question_txt_description.text = questionData.description
        question_txt_description.scaleCenter()

        if (questionData.explanation.isNotEmpty()) {
            question_txt_explanation.text = questionData.explanation
            question_txt_explanation.scaleCenter()
        }
    }

    private fun bindElements() {
        question_btn_play.setOnClickListener { questionPresenter.sort() }
    }
}

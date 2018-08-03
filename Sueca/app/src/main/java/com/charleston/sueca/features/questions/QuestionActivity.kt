package com.charleston.sueca.features.questions

import android.app.AlertDialog
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import com.charleston.sueca.R
import com.charleston.sueca.extensions.fade
import com.charleston.sueca.extensions.hide
import com.charleston.sueca.extensions.show
import kotlinx.android.synthetic.main.activity_question.*


class QuestionActivity : AppCompatActivity(), QuestionView {

    private val questionPresenter by lazy { QuestionPresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        bindElements()

        main_ctn_question.hide()
    }

    override fun showQuestion(questionData: QuestionData, @IdRes card: Int) {
        animateCard(main_iv_card, card)
        main_txt_description.text = questionData.description
        main_txt_description.show()
        main_txt_description.fade()

        if (questionData.explanation.isNotEmpty()) {
            main_ctn_question.show()
            main_ctn_question.fade()
        } else {
            main_ctn_question.hide()
        }
    }

    private fun bindElements() {
        main_btn_play.setOnClickListener { play() }
        main_ctn_question.setOnClickListener { showExplanation() }
    }

    private fun play() {
        questionPresenter.sort()
    }

    private fun showExplanation() {
        AlertDialog.Builder(this)
                .setMessage(questionPresenter.getQuestionCurrent()?.explanation)
                .setCancelable(true)
                .show()
    }

    private fun animateCard(view: ImageView, image: Int) {
        val duration: Long = 750
        main_btn_play.isEnabled = false
        view.animate()
                .setDuration(duration)
                .rotationYBy(180f)
                .withEndAction {
                    view.animate()
                            .setDuration(duration)
                            .rotationYBy(90f)
                            .withEndAction {
                                view.setImageDrawable(ContextCompat.getDrawable(this@QuestionActivity, image))
                                view.animate()
                                        .setDuration(duration)
                                        .rotationYBy(90f)
                                        .withEndAction {  main_btn_play.isEnabled = true }
                                        .start()
                            }
                            .start()
                }
                .start()
    }
}

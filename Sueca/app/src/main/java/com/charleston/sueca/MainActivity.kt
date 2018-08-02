package com.charleston.sueca

import android.os.Bundle
import android.support.annotation.IdRes
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), QuestionView {

    private val questionPresenter by lazy { QuestionPresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindElements()
    }

    override fun showQuestion(questionData: QuestionData, @IdRes card: Int) {
        animateCard(main_iv_card, card)
        main_txt_description.text = questionData.description
        main_txt_description.fade()
    }

    private fun bindElements() {
        main_btn_play.setOnClickListener { play() }
    }

    private fun play() {
        questionPresenter.sort()
    }

    private fun animateCard(view: ImageView, image: Int) {
        val duration: Long = 750

        view.animate()
                .setDuration(duration)
                .rotationYBy(180f)
                .withEndAction {
                    view.animate()
                            .setDuration(duration)
                            .rotationYBy(90f)
                            .withEndAction {
                                view.setImageDrawable(ContextCompat.getDrawable(this@MainActivity, image))
                                view.animate()
                                        .setDuration(duration)
                                        .rotationYBy(90f)
                                        .start()
                            }
                            .start()
                }
                .start()
    }
}

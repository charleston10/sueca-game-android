package com.example.charleston.testanimation

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewPropertyAnimator
import android.view.animation.AlphaAnimation
import android.view.animation.AnimationSet
import android.view.animation.DecelerateInterpolator
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v4.view.ViewCompat.animate


class MainActivity : AppCompatActivity() {

    private var front = 0f

    private val rotate = 90f
    private val duration: Long = 750

    private var changed = false
    private val cardImages = arrayListOf(R.drawable.d10, R.drawable.card_two_gold)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        play_button.setOnClickListener { animateCard() }

        main_card.setOnTouchListener(object : OnSwipeTouchListener(this) {
            override fun onSwipeLeft() {
                super.onSwipeLeft()
                animateCard(false)
            }

            override fun onSwipeRight() {
                super.onSwipeRight()
                animateCard()
            }
        })
    }

    private fun animateCard(isRight: Boolean = true) {
        val image = if (changed) cardImages[1] else cardImages[0]
        main_card.animate()
                .setDuration(duration)
                .rotationYBy(180f)
                .withEndAction {
                    main_card.animate()
                            .setDuration(duration)
                            .rotationYBy(90f)
                            .withEndAction {
                                main_card.setImageDrawable(ContextCompat.getDrawable(this@MainActivity, image))
                                main_card.animate()
                                        .setDuration(duration)
                                        .rotationYBy(90f)
                                        .start()
                            }
                            .start()
                }
                .start()

        changed = !changed
        animateFade()
    }

    private fun animateFade() {
        val fadeIn = AlphaAnimation(0f, 1f)
        fadeIn.interpolator = DecelerateInterpolator() //add this
        fadeIn.duration = 1500

        val animation = AnimationSet(false) //change to false
        animation.addAnimation(fadeIn)
        description.startAnimation(animation)
    }
}

package com.charleston.sueca

import android.view.View
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_main.*

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.GONE
}

fun View.scaleCenter() {
    val animation = AnimationUtils.loadAnimation(context, R.anim.scale)
    animation.reset()
    clearAnimation()
    startAnimation(animation)
}
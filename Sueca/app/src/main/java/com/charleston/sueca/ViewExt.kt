package com.charleston.sueca

import android.view.View
import android.view.animation.*

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

fun View.fade(){
    val fadeIn = AlphaAnimation(0f, 1f)
    fadeIn.interpolator = DecelerateInterpolator()
    fadeIn.duration = 1500

    val animation = AnimationSet(false)
    animation.addAnimation(fadeIn)
    startAnimation(animation)
}
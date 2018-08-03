package com.charleston.sueca.features.onboarding

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.charleston.sueca.R
import com.charleston.sueca.features.questions.QuestionActivity

/**
 * Created by charleston on 03/08/2018.
 */
class OnboardingActivity : AppCompatActivity() {

    private val splashDelay: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)
    }
}
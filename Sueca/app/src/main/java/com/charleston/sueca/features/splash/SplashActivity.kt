package com.charleston.sueca.features.splash

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.charleston.sueca.R
import com.charleston.sueca.features.questions.QuestionActivity
import kotlinx.android.synthetic.main.activity_splash.*

/**
 * Created by charleston on 03/08/2018.
 */
class SplashActivity : BaseActivity() {

    private val splashDelay: Long = 3000

    override fun screenName(): String = "SplashActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            splash_title.animate().alpha(0f).setDuration(500).withEndAction {
                startActivity(QuestionActivity.getIntent(this))
                finish()
            }.start()
        }, splashDelay)
    }
}
package com.project.armovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        var handler = Handler()
        handler.postDelayed({
            val intent = Intent(this@SplashScreenActivity,
                OnboardingOneActivity::class.java)
            startActivity(intent)
            finish()
        }, 5000)
    }
}
}

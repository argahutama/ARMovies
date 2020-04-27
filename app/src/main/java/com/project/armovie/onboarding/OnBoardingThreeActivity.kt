package com.project.armovie.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.project.armovie.R
import com.project.armovie.sign.signin.SignInActivity
import kotlinx.android.synthetic.main.activity_on_boarding_three.*

class OnBoardingThreeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding_three)

        btn_getting_started.setOnClickListener {
            finishAffinity()

            val intent = Intent(this@OnBoardingThreeActivity,
                SignInActivity::class.java)
            startActivity(intent)
        }
    }

}

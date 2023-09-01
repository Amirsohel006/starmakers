package com.starmakers.app.modules.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.starmakers.app.R

class SplashScreen2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen2)

        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        Handler().postDelayed({
            val intent = Intent(this, SplashScreen3::class.java)
            startActivity(intent)
            finish() // Finish this activity to prevent going back to it
        }, 3000)
    }
}
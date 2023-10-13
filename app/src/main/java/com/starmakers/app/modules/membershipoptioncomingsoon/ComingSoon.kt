package com.starmakers.app.modules.membershipoptioncomingsoon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.starmakers.app.R

class ComingSoon : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coming_soon)
        window.statusBarColor= ContextCompat.getColor(this,R.color.statusbar2)
    }
}
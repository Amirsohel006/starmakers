package com.starmakers.app.modules.splashscreen

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.starmakers.app.R
import com.starmakers.app.modules.homecontainer.ui.HomeContainerActivity
import com.starmakers.app.modules.signuofour.ui.SignUoFourActivity
import com.starmakers.app.modules.signuotwo.ui.LoginActivity

class SplashScreen1 : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    private lateinit var imageView: ImageView
    private lateinit var indicator1: ImageView
    private lateinit var indicator2: ImageView
    private lateinit var indicator3: ImageView
    private lateinit var indicator4: ImageView
    private lateinit var indicator5: ImageView
    private lateinit var skipbutton:ImageView
    // Add more indicator ImageViews as needed

    private val imageArray = arrayOf(
        R.drawable.image2splash,
        R.drawable.image3splash,
        R.drawable.image4,
        R.drawable.image5splash

        // Add more image resources as needed
    )

    private var currentIndex = 0
    private val handler = Handler()
    private val imageChangeRunnable = object : Runnable {
        override fun run() {
            // Update the ImageView with the next image
            imageView.setImageResource(imageArray[currentIndex])

            // Update the custom shape indicators
            updateIndicator(currentIndex)

            // Increment the index or reset it if it reaches the end
            currentIndex = (currentIndex + 1) % imageArray.size

            // Schedule the next image change after 3 seconds
            handler.postDelayed(this, 3000)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen1)

        imageView = findViewById(R.id.imageView)

        // Initialize the indicator ImageViews
        indicator1 = findViewById(R.id.indicator1)
        indicator2 = findViewById(R.id.indicator2)
        indicator3 = findViewById(R.id.indicator3)
        indicator4=findViewById(R.id.indicator4)
        indicator5=findViewById(R.id.indicator5)
        // Initialize more indicator ImageViews as needed


        // Define a handler outside of onCreate
        val handler = Handler()

// Start the image change process
        handler.post(imageChangeRunnable)

// After a certain duration (e.g., 10 seconds), navigate to the next activity
        val delayToNextActivity = 10000 // 10 seconds
        val delayedIntent = Intent(this, LoginActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            delayedIntent,
            PendingIntent.FLAG_CANCEL_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        Handler().postDelayed({
            startActivity(delayedIntent)
            finishAffinity() // Finish this activity to prevent going back to it
        }, delayToNextActivity.toLong())

        skipbutton = findViewById(R.id.skipbutton)
        skipbutton.setOnClickListener {
            // Cancel the delayed intent if the skip button is clicked
            handler.removeCallbacksAndMessages(null)
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }



        sharedPreferences = getSharedPreferences("my_preferences", Context.MODE_PRIVATE)

        val accessToken = sharedPreferences.getString("access_token", null)
        if (accessToken != null) {
            // User is already logged in, navigate to the home container activity
            navigatetonextpage()
        }

// Change the status bar color to transparent
        window.statusBarColor = Color.TRANSPARENT

    }


    private fun navigatetonextpage(){
        val i=HomeContainerActivity.getIntent(this,null)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(i)
    }
    private fun updateIndicator(currentIndex: Int) {
        // Reset all indicators to unselected state
        indicator1.setImageResource(R.drawable.indicator_unselected)
        indicator2.setImageResource(R.drawable.indicator_unselected)
        indicator3.setImageResource(R.drawable.indicator_unselected)
        indicator4.setImageResource(R.drawable.indicator_unselected)
        indicator5.setImageResource(R.drawable.indicator_unselected)
        // Update more indicators as needed

        // Set the selected indicator based on the current index
        when (currentIndex) {
            0 -> indicator1.setImageResource(R.drawable.indicator_selected)
            1 -> indicator2.setImageResource(R.drawable.indicator_selected)
            2 -> indicator3.setImageResource(R.drawable.indicator_selected)
            3 -> indicator4.setImageResource(R.drawable.indicator_selected)
            4 -> indicator5.setImageResource(R.drawable.indicator_selected)
            // Update more indicators as needed
        }
    }
}

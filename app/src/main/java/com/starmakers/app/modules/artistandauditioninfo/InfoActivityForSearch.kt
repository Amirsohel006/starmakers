package com.starmakers.app.modules.artistandauditioninfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.starmakers.app.R

class InfoActivityForSearch : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_for_search)

        window.statusBarColor= ContextCompat.getColor(this,R.color.statusbar2)

    }
}
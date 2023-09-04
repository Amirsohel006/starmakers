package com.starmakers.app.modules.artistbookong.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityArtistBookongBinding
import com.starmakers.app.modules.artistbookong.`data`.viewmodel.ArtistBookongVM
import com.starmakers.app.modules.signuotwo.ui.LoginActivity
import kotlin.String
import kotlin.Unit

class ArtistBookongActivity :
    BaseActivity<ActivityArtistBookongBinding>(R.layout.activity_artist_bookong) {
  private val viewModel: ArtistBookongVM by viewModels<ArtistBookongVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.artistBookongVM = viewModel

    window.statusBarColor= ContextCompat.getColor(this,R.color.statusbar2)
  }

  override fun setUpClicks(): Unit {
    binding.btnLogout.setOnClickListener {
      val destIntent = LoginActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "ARTIST_BOOKONG_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, ArtistBookongActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}

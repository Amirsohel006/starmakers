package com.starmakers.app.modules.frame313.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityFrame313Binding
import com.starmakers.app.modules.artistbookong.ui.ArtistBookongActivity
import com.starmakers.app.modules.frame313.`data`.viewmodel.Frame313VM
import kotlin.String
import kotlin.Unit

class Frame313Activity : BaseActivity<ActivityFrame313Binding>(R.layout.activity_frame_313) {
  private val viewModel: Frame313VM by viewModels<Frame313VM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.frame313VM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.linearColumnregistrationsu.setOnClickListener {
      val destIntent = ArtistBookongActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "FRAME313ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, Frame313Activity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}

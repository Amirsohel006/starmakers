package com.starmakers.app.modules.frametwentythree.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityFrameTwentythreeBinding
import com.starmakers.app.modules.auditions.ui.AuditionsActivity
import com.starmakers.app.modules.frametwentythree.`data`.viewmodel.FrameTwentythreeVM
import kotlin.String
import kotlin.Unit

class FrameTwentythreeActivity :
    BaseActivity<ActivityFrameTwentythreeBinding>(R.layout.activity_frame_twentythree) {
  private val viewModel: FrameTwentythreeVM by viewModels<FrameTwentythreeVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.frameTwentythreeVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.linearColumnparticipations.setOnClickListener {
      val destIntent = AuditionsActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "FRAME_TWENTYTHREE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, FrameTwentythreeActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}

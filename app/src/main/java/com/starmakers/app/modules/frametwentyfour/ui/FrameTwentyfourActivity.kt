package com.starmakers.app.modules.frametwentyfour.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityFrameTwentyfourBinding
import com.starmakers.app.modules.frametwentyfour.`data`.viewmodel.FrameTwentyfourVM
import com.starmakers.app.modules.homecontainer.ui.HomeContainerActivity
import kotlin.String
import kotlin.Unit

class FrameTwentyfourActivity :
    BaseActivity<ActivityFrameTwentyfourBinding>(R.layout.activity_frame_twentyfour) {
  private val viewModel: FrameTwentyfourVM by viewModels<FrameTwentyfourVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.frameTwentyfourVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.linearColumnregistrationsu.setOnClickListener {
      val destIntent = HomeContainerActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "FRAME_TWENTYFOUR_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, FrameTwentyfourActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}

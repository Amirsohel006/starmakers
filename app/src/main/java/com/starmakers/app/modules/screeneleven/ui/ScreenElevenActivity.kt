package com.starmakers.app.modules.screeneleven.ui

import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityScreenElevenBinding
import com.starmakers.app.modules.screeneleven.`data`.viewmodel.ScreenElevenVM
import kotlin.String
import kotlin.Unit

class ScreenElevenActivity :
    BaseActivity<ActivityScreenElevenBinding>(R.layout.activity_screen_eleven) {
  private val viewModel: ScreenElevenVM by viewModels<ScreenElevenVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.screenElevenVM = viewModel

    window.statusBarColor= ContextCompat.getColor(this,R.color.statusbar2)
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "SCREEN_ELEVEN_ACTIVITY"

  }
}

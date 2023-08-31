package com.starmakers.app.modules.screenfive.ui

import androidx.activity.viewModels
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityScreenFiveBinding
import com.starmakers.app.modules.screenfive.`data`.viewmodel.ScreenFiveVM
import kotlin.String
import kotlin.Unit

class ScreenFiveActivity : BaseActivity<ActivityScreenFiveBinding>(R.layout.activity_screen_five) {
  private val viewModel: ScreenFiveVM by viewModels<ScreenFiveVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.screenFiveVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "SCREEN_FIVE_ACTIVITY"

  }
}

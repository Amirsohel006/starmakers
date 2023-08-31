package com.starmakers.app.modules.screenseven.ui

import androidx.activity.viewModels
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityScreenSevenBinding
import com.starmakers.app.modules.screenseven.`data`.viewmodel.ScreenSevenVM
import kotlin.String
import kotlin.Unit

class ScreenSevenActivity : BaseActivity<ActivityScreenSevenBinding>(R.layout.activity_screen_seven)
    {
  private val viewModel: ScreenSevenVM by viewModels<ScreenSevenVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.screenSevenVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "SCREEN_SEVEN_ACTIVITY"

  }
}

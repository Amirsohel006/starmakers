package com.starmakers.app.modules.screeneight.ui

import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityScreenEightBinding
import com.starmakers.app.modules.screeneight.`data`.viewmodel.ScreenEightVM
import kotlin.String
import kotlin.Unit

class ScreenEightActivity : BaseActivity<ActivityScreenEightBinding>(R.layout.activity_screen_eight)
    {
  private val viewModel: ScreenEightVM by viewModels<ScreenEightVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.screenEightVM = viewModel

    window.statusBarColor= ContextCompat.getColor(this,R.color.statusbar2)
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "SCREEN_EIGHT_ACTIVITY"

  }
}

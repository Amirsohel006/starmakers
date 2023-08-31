package com.starmakers.app.modules.helptwo.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityHelpTwoBinding
import com.starmakers.app.modules.helptwo.`data`.viewmodel.HelpTwoVM
import kotlin.String
import kotlin.Unit

class HelpTwoActivity : BaseActivity<ActivityHelpTwoBinding>(R.layout.activity_help_two) {
  private val viewModel: HelpTwoVM by viewModels<HelpTwoVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.helpTwoVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "HELP_TWO_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, HelpTwoActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}

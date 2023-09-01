package com.starmakers.app.modules.helpone.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityHelpOneBinding
import com.starmakers.app.modules.helpone.`data`.viewmodel.HelpOneVM
import kotlin.String
import kotlin.Unit

class HelpOneActivity : BaseActivity<ActivityHelpOneBinding>(R.layout.activity_help_one) {
  private val viewModel: HelpOneVM by viewModels<HelpOneVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.helpOneVM = viewModel

    window.statusBarColor= ContextCompat.getColor(this,R.color.statusbar2)
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "HELP_ONE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, HelpOneActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}

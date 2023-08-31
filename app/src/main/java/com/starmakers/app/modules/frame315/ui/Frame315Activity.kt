package com.starmakers.app.modules.frame315.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityFrame315Binding
import com.starmakers.app.modules.frame315.`data`.viewmodel.Frame315VM
import kotlin.String
import kotlin.Unit

class Frame315Activity : BaseActivity<ActivityFrame315Binding>(R.layout.activity_frame_315) {
  private val viewModel: Frame315VM by viewModels<Frame315VM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.frame315VM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "FRAME315ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, Frame315Activity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}

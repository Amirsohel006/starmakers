package com.starmakers.app.modules.frame317.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityFrame317Binding
import com.starmakers.app.modules.frame317.`data`.viewmodel.Frame317VM
import com.starmakers.app.modules.homecontainer.ui.HomeContainerActivity
import kotlin.String
import kotlin.Unit

class Frame317Activity : BaseActivity<ActivityFrame317Binding>(R.layout.activity_frame_317) {
  private val viewModel: Frame317VM by viewModels<Frame317VM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.frame317VM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.linearColumndonationsucces.setOnClickListener {
      val destIntent = HomeContainerActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "FRAME317ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, Frame317Activity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}

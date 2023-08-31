package com.starmakers.app.modules.frame316.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityFrame316Binding
import com.starmakers.app.modules.frame315.ui.Frame315Activity
import com.starmakers.app.modules.frame316.`data`.viewmodel.Frame316VM
import kotlin.String
import kotlin.Unit

class Frame316Activity : BaseActivity<ActivityFrame316Binding>(R.layout.activity_frame_316) {
  private val viewModel: Frame316VM by viewModels<Frame316VM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.frame316VM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnRequestStudio.setOnClickListener {
      val destIntent = Frame315Activity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "FRAME316ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, Frame316Activity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}

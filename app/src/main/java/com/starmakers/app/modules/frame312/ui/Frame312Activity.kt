package com.starmakers.app.modules.frame312.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityFrame312Binding
import com.starmakers.app.modules.artistbookongtwo.ui.ArtistBookongTwoActivity
import com.starmakers.app.modules.frame312.`data`.viewmodel.Frame312VM
import kotlin.String
import kotlin.Unit

class Frame312Activity : BaseActivity<ActivityFrame312Binding>(R.layout.activity_frame_312) {
  private val viewModel: Frame312VM by viewModels<Frame312VM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.frame312VM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.linearColumnrequestsuccess.setOnClickListener {
      val destIntent = ArtistBookongTwoActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "FRAME312ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, Frame312Activity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}

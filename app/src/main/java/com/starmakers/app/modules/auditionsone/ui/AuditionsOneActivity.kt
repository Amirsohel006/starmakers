package com.starmakers.app.modules.auditionsone.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityAuditionsOneBinding
import com.starmakers.app.modules.auditionsone.`data`.viewmodel.AuditionsOneVM
import kotlin.String
import kotlin.Unit

class AuditionsOneActivity :
    BaseActivity<ActivityAuditionsOneBinding>(R.layout.activity_auditions_one) {
  private val viewModel: AuditionsOneVM by viewModels<AuditionsOneVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.auditionsOneVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "AUDITIONS_ONE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, AuditionsOneActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}

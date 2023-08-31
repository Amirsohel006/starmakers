package com.starmakers.app.modules.signuoone.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivitySignUoOneBinding
import com.starmakers.app.modules.homecontainer.ui.HomeContainerActivity
import com.starmakers.app.modules.signuoone.`data`.viewmodel.SignUoOneVM
import kotlin.String
import kotlin.Unit

class SignUoOneActivity : BaseActivity<ActivitySignUoOneBinding>(R.layout.activity_sign_uo_one) {
  private val viewModel: SignUoOneVM by viewModels<SignUoOneVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.signUoOneVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnComplete.setOnClickListener {
      val destIntent = HomeContainerActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "SIGN_UO_ONE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SignUoOneActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}

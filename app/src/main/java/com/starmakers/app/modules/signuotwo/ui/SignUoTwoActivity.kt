package com.starmakers.app.modules.signuotwo.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivitySignUoTwoBinding
import com.starmakers.app.modules.signuofour.ui.SignUoFourActivity
import com.starmakers.app.modules.signuothree.ui.SignUoThreeActivity
import com.starmakers.app.modules.signuotwo.`data`.viewmodel.SignUoTwoVM
import kotlin.String
import kotlin.Unit

class SignUoTwoActivity : BaseActivity<ActivitySignUoTwoBinding>(R.layout.activity_sign_uo_two) {
  private val viewModel: SignUoTwoVM by viewModels<SignUoTwoVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.signUoTwoVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.txtSignup.setOnClickListener {
      val destIntent = SignUoFourActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnLogin.setOnClickListener {
      val destIntent = SignUoThreeActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "SIGN_UO_TWO_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SignUoTwoActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}

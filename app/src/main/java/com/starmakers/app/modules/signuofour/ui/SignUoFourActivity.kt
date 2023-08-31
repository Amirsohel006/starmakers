package com.starmakers.app.modules.signuofour.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivitySignUoFourBinding
import com.starmakers.app.modules.signuo.ui.SignUoActivity
import com.starmakers.app.modules.signuofour.`data`.viewmodel.SignUoFourVM
import com.starmakers.app.modules.signuotwo.ui.SignUoTwoActivity
import kotlin.String
import kotlin.Unit

class SignUoFourActivity : BaseActivity<ActivitySignUoFourBinding>(R.layout.activity_sign_uo_four) {
  private val viewModel: SignUoFourVM by viewModels<SignUoFourVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.signUoFourVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnSignup.setOnClickListener {
      val destIntent = SignUoActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.txtLogin.setOnClickListener {
      val destIntent = SignUoTwoActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "SIGN_UO_FOUR_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SignUoFourActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}

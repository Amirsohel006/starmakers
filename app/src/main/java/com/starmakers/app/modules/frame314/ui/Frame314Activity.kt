package com.starmakers.app.modules.frame314.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityFrame314Binding
import com.starmakers.app.modules.artistmembershipone.ui.ArtistMembershipOneActivity
import com.starmakers.app.modules.frame314.`data`.viewmodel.Frame314VM
import kotlin.String
import kotlin.Unit

class Frame314Activity : BaseActivity<ActivityFrame314Binding>(R.layout.activity_frame_314) {
  private val viewModel: Frame314VM by viewModels<Frame314VM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.frame314VM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnTakeMembershipOne.setOnClickListener {
      val destIntent = ArtistMembershipOneActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "FRAME314ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, Frame314Activity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}

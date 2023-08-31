package com.starmakers.app.modules.request.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityRequestBinding
import com.starmakers.app.modules.auditionstwo.ui.AuditionsTwoActivity
import com.starmakers.app.modules.request.`data`.viewmodel.RequestVM
import com.starmakers.app.modules.requestone.ui.RequestOneActivity
import kotlin.String
import kotlin.Unit

class RequestActivity : BaseActivity<ActivityRequestBinding>(R.layout.activity_request) {
  private val viewModel: RequestVM by viewModels<RequestVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.requestVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageRectangleNineteen.setOnClickListener {
      val destIntent = AuditionsTwoActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.txtRamanandStudio.setOnClickListener {
      val destIntent = AuditionsTwoActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
    binding.txtArtistRequests.setOnClickListener {
      val destIntent = RequestOneActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "REQUEST_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, RequestActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}

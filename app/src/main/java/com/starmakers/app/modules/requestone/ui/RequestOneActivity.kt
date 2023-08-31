package com.starmakers.app.modules.requestone.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityRequestOneBinding
import com.starmakers.app.modules.artistbookongthree.ui.ArtistBookongThreeActivity
import com.starmakers.app.modules.request.ui.RequestActivity
import com.starmakers.app.modules.requestone.`data`.viewmodel.RequestOneVM
import kotlin.String
import kotlin.Unit

class RequestOneActivity : BaseActivity<ActivityRequestOneBinding>(R.layout.activity_request_one) {
  private val viewModel: RequestOneVM by viewModels<RequestOneVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.requestOneVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.txtSudeep.setOnClickListener {
      val destIntent = ArtistBookongThreeActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
    binding.imageRectangleNineteen.setOnClickListener {
      val destIntent = ArtistBookongThreeActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.txtStudioRequests.setOnClickListener {
      val destIntent = RequestActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "REQUEST_ONE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, RequestOneActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}

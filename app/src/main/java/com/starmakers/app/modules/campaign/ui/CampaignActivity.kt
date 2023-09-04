package com.starmakers.app.modules.campaign.ui

import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityCampaignBinding
import com.starmakers.app.modules.campaign.`data`.viewmodel.CampaignVM
import com.starmakers.app.modules.paymentpage.ui.PaymentPageActivity
import kotlin.String
import kotlin.Unit

class CampaignActivity : BaseActivity<ActivityCampaignBinding>(R.layout.activity_campaign) {
  private val viewModel: CampaignVM by viewModels<CampaignVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.campaignVM = viewModel
    window.statusBarColor= ContextCompat.getColor(this,R.color.statusbar2)
  }

  override fun setUpClicks(): Unit {
    binding.btnDonate.setOnClickListener {
      val destIntent = PaymentPageActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "CAMPAIGN_ACTIVITY"

  }
}

package com.starmakers.app.modules.campaignone.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityCampaignOneBinding
import com.starmakers.app.modules.auditionsfour.ui.AuditionsFourActivity
import com.starmakers.app.modules.campaignone.`data`.viewmodel.CampaignOneVM
import kotlin.String
import kotlin.Unit

class CampaignOneActivity : BaseActivity<ActivityCampaignOneBinding>(R.layout.activity_campaign_one)
    {
  private val viewModel: CampaignOneVM by viewModels<CampaignOneVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.campaignOneVM = viewModel

    window.statusBarColor= ContextCompat.getColor(this,R.color.statusbar2)
  }

  override fun setUpClicks(): Unit {
    binding.btnParticipate.setOnClickListener {
      val destIntent = AuditionsFourActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "CAMPAIGN_ONE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, CampaignOneActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}

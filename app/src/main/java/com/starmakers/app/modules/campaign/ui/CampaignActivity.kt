package com.starmakers.app.modules.campaign.ui

import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityCampaignBinding
import com.starmakers.app.modules.auditionsfour.ui.AuditionsFourActivity
import com.starmakers.app.modules.campaign.`data`.viewmodel.CampaignVM
import com.starmakers.app.modules.paymentpage.ui.PaymentPageActivity
import com.starmakers.app.responses.CrowdByIdResponses
import com.starmakers.app.service.ApiManager
import com.starmakers.app.service.SessionManager
import retrofit2.Call
import retrofit2.Response
import kotlin.String
import kotlin.Unit

class CampaignActivity : BaseActivity<ActivityCampaignBinding>(R.layout.activity_campaign) {
  private val viewModel: CampaignVM by viewModels<CampaignVM>()

  private lateinit var sessionManager: SessionManager
  override fun onInitialized(): Unit {
    sessionManager=SessionManager(this)
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.campaignVM = viewModel

    val poster=intent.getStringExtra("poster")
    val movieName=intent.getStringExtra("movie_name")
    val venue=intent.getStringExtra("venue")
    val audition_date=intent.getStringExtra("audtion_date")
    val start_Time=intent.getStringExtra("start_time")
    val end_time=intent.getStringExtra("end_time")
    val storyLine=intent.getStringExtra("storyline")
    val audition_Id=intent.getIntExtra("artistDataId",-1)


    Glide.with(this)
      .load(poster) // Replace with your image URL or resource ID
      .into(binding.imageRectangleTen)

    binding.txtMovieKantara1.text=movieName

    binding.txtKANTARA.text=movieName
    binding.txtGenreMystery1.text=venue

    binding.txtDescription.text=storyLine

    binding.txtMovieStartDat1.text=audition_date

    binding.txtMovieEndDate1.text=start_Time

    binding.txtReleasingDate1.text=end_time


    binding.btnParticipate.setOnClickListener {
      val intent = Intent(this, AuditionsFourActivity::class.java)
      intent.putExtra("artistDataId", audition_Id) // Pass the id to the new activity
      startActivity(intent)
    }

    window.statusBarColor= ContextCompat.getColor(this,R.color.statusbar2)
  }

  override fun setUpClicks(): Unit {
//    binding.btnParticipate.setOnClickListener {
//      val destIntent = PaymentPageActivity.getIntent(this, null)
//      startActivity(destIntent)
//    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }



  companion object {
    const val TAG: String = "CAMPAIGN_ACTIVITY"

  }
}

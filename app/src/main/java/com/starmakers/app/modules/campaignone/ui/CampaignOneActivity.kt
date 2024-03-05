package com.starmakers.app.modules.campaignone.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.squareup.picasso.Picasso
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityCampaignOneBinding
import com.starmakers.app.modules.auditionsfour.ui.AuditionsFourActivity
import com.starmakers.app.modules.campaignone.`data`.viewmodel.CampaignOneVM
import com.starmakers.app.modules.paymentpage.ui.PaymentPageActivity
import com.starmakers.app.responses.CrowdByIdResponses
import com.starmakers.app.responses.CrowdResponses
import com.starmakers.app.service.ApiManager
import com.starmakers.app.service.SessionManager
import org.koin.android.ext.android.bind
import retrofit2.Call
import retrofit2.Response
import kotlin.String
import kotlin.Unit

class CampaignOneActivity : BaseActivity<ActivityCampaignOneBinding>(R.layout.activity_campaign_one)
    {
  private val viewModel: CampaignOneVM by viewModels<CampaignOneVM>()

      private lateinit var sessionManager:SessionManager
      private var itemId:String=""
  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.campaignOneVM = viewModel

    sessionManager= SessionManager(this)
     itemId=intent.getStringExtra("itemId")!!

    getCrowdFundingZone(itemId)


    window.statusBarColor= ContextCompat.getColor(this,R.color.statusbar2)
  }

  override fun setUpClicks(): Unit {
    binding.btnParticipate.setOnClickListener {
      val destIntent = PaymentPageActivity.getIntent(this, null)
      destIntent.putExtra("itemId",itemId)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

      fun getCrowdFundingZone(id:String){
        val serviceGenerator = ApiManager.apiInterface
        val accessToken = sessionManager.fetchAuthToken()
        val authorization = "Token $accessToken"
        val call = serviceGenerator.getCrowdImageByid(authorization,id)

        call.enqueue(object : retrofit2.Callback<CrowdByIdResponses> {
          override fun onResponse(
            call: Call<CrowdByIdResponses>,
            response: Response<CrowdByIdResponses>
          ) {

            val crowdByIdResponses = response.body()

            if(crowdByIdResponses!!.status=="success" || crowdByIdResponses.campaignData!= null) {
              val movieposter = crowdByIdResponses.campaignData!!.moviePoster?:""

              val file = ApiManager.getImageUrl(movieposter)

              Picasso.get().load(file).into(binding.imageRectangleTen)


              binding.txtKANTARA.text=crowdByIdResponses.campaignData!!.campaignsName

              binding.txtMovieKantara1.text = crowdByIdResponses.campaignData!!.campaignsName

              binding.txtGenreMystery1.text = crowdByIdResponses.campaignData!!.genere

              binding.txtDescription.text = crowdByIdResponses.campaignData!!.oneLineStory

              binding.txtAppxBudget1.text = crowdByIdResponses.campaignData!!.appxBudget

              binding.txtMovieStartDat1.text = crowdByIdResponses.campaignData!!.movieStartDate

              binding.txtMovieEndDate1.text = crowdByIdResponses.campaignData!!.movieStartEnd


              binding.txtReleasingDate1.text=crowdByIdResponses.campaignData!!.movieStartEnd

              val actor1 = crowdByIdResponses.campaignData!!.actorPicture1

              val actor2 = crowdByIdResponses.campaignData!!.actorPicture2

              val actor3 = crowdByIdResponses.campaignData!!.actorPicture3

              val file1 = ApiManager.getImageUrl(actor1?:"")
              val file2 = ApiManager.getImageUrl(actor2?:"")
              val file3 = ApiManager.getImageUrl(actor3?:"")


              Picasso.get().load(file1).into(binding.imageRectangle147)
              Picasso.get().load(file2).into(binding.imageRectangle148)
              Picasso.get().load(file3).into(binding.imageRectangle149)
            }else{
              Toast.makeText(this@CampaignOneActivity,"Responses Are Not Good",Toast.LENGTH_SHORT).show()
            }
          }

          override fun onFailure(call: Call<CrowdByIdResponses>, t: Throwable) {
            t.printStackTrace()
            Log.e("error", t.message.toString())
          }
        })
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

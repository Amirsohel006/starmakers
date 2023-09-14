package com.starmakers.app.modules.request.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityRequestBinding
import com.starmakers.app.modules.auditionstwo.ui.AuditionsTwoActivity
import com.starmakers.app.modules.request.`data`.viewmodel.RequestVM
import com.starmakers.app.modules.requestone.ui.ArtistRequestAdapter
import com.starmakers.app.modules.requestone.ui.RequestOneActivity
import com.starmakers.app.responses.ArtistRequests
import com.starmakers.app.responses.StudioRequests
import com.starmakers.app.service.ApiManager
import com.starmakers.app.service.SessionManager
import retrofit2.Call
import retrofit2.Response
import kotlin.String
import kotlin.Unit

class RequestActivity : BaseActivity<ActivityRequestBinding>(R.layout.activity_request) {
  private val viewModel: RequestVM by viewModels<RequestVM>()

  private lateinit var sessionManager: SessionManager
  override fun onInitialized(): Unit {
    sessionManager=SessionManager(this)
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.requestVM = viewModel

    fetchStudioRequest()
    window.statusBarColor= ContextCompat.getColor(this,R.color.statusbar2)
  }

  override fun setUpClicks(): Unit {
//    binding.imageRectangleNineteen.setOnClickListener {
//      val destIntent = AuditionsTwoActivity.getIntent(this, null)
//      startActivity(destIntent)
//    }
//    binding.txtRamanandStudio.setOnClickListener {
//      val destIntent = AuditionsTwoActivity.getIntent(this, null)
//      startActivity(destIntent)
//    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
    binding.txtArtistRequests.setOnClickListener {
      val destIntent = RequestOneActivity.getIntent(this, null)
      startActivity(destIntent)
      finish()
    }
  }


  fun fetchStudioRequest(){
    val serviceGenerator= ApiManager.apiInterface
    val accessToken=sessionManager.fetchAuthToken()
    val authorization="Token $accessToken"
    val call=serviceGenerator.getStudioRequest(authorization)


    call.enqueue(object : retrofit2.Callback<MutableList<StudioRequests>>{
      override fun onResponse(
        call: Call<MutableList<StudioRequests>>,
        response: Response<MutableList<StudioRequests>>
      ) {
        val customerResponse=response.body()

        if(customerResponse!=null){
          val responsefinal=response.body()

          binding.recylerviewforStudio.apply {
            layoutManager=
              LinearLayoutManager(this@RequestActivity, LinearLayoutManager.VERTICAL,false)
            val studioadapter= responsefinal?.let { StudioRequestAdapter(it) }
            binding.recylerviewforStudio.adapter=studioadapter
          }
        }
      }

      override fun onFailure(call: Call<MutableList<StudioRequests>>, t: Throwable) {
        t.printStackTrace()
        Log.e("error", t.message.toString())
      }
    })
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

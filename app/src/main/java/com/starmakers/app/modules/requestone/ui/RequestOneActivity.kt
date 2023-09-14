package com.starmakers.app.modules.requestone.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityRequestOneBinding
import com.starmakers.app.modules.artistbookongthree.ui.ArtistBookongThreeActivity
import com.starmakers.app.modules.request.ui.RequestActivity
import com.starmakers.app.modules.requestone.`data`.viewmodel.RequestOneVM
import com.starmakers.app.responses.ArtistRequests
import com.starmakers.app.responses.ProfileResponse
import com.starmakers.app.service.ApiManager
import com.starmakers.app.service.CircleTransformation
import com.starmakers.app.service.SessionManager
import retrofit2.Call
import retrofit2.Response
import kotlin.String
import kotlin.Unit

class RequestOneActivity : BaseActivity<ActivityRequestOneBinding>(R.layout.activity_request_one) {
  private val viewModel: RequestOneVM by viewModels<RequestOneVM>()

  private lateinit var sessionManager: SessionManager
  override fun onInitialized(): Unit {
    sessionManager=SessionManager(this)
    fetchArtistRequest()

    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.requestOneVM = viewModel
    window.statusBarColor= ContextCompat.getColor(this,R.color.statusbar2)

  }

  override fun setUpClicks(): Unit {
//    binding.txtSudeep.setOnClickListener {
//      val destIntent = ArtistBookongThreeActivity.getIntent(this, null)
//      startActivity(destIntent)
//    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
//    binding.imageRectangleNineteen.setOnClickListener {
//      val destIntent = ArtistBookongThreeActivity.getIntent(this, null)
//      startActivity(destIntent)
//    }
    binding.txtStudioRequests.setOnClickListener {
      val destIntent = RequestActivity.getIntent(this, null)
      startActivity(destIntent)
      finish()
    }
  }


  fun fetchArtistRequest(){
    val serviceGenerator= ApiManager.apiInterface
    val accessToken=sessionManager.fetchAuthToken()
    val authorization="Token $accessToken"
    val call=serviceGenerator.getUserRequest(authorization)


    call.enqueue(object : retrofit2.Callback<MutableList<ArtistRequests>>{
      override fun onResponse(
        call: Call<MutableList<ArtistRequests>>,
        response: Response<MutableList<ArtistRequests>>
      ) {
        val customerResponse=response.body()

        if(customerResponse!=null){
          val responsefinal=response.body()
          binding.recyclerviewArtist.apply {
            layoutManager=
              LinearLayoutManager(this@RequestOneActivity, LinearLayoutManager.VERTICAL,false)
            val artistadapter= responsefinal?.let { ArtistRequestAdapter(it) }
            binding.recyclerviewArtist.adapter=artistadapter
          }
        }
      }

      override fun onFailure(call: Call<MutableList<ArtistRequests>>, t: Throwable) {
        t.printStackTrace()
        Log.e("error", t.message.toString())
      }
    })
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

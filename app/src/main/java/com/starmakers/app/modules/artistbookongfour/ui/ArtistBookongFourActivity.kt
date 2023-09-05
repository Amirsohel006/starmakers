package com.starmakers.app.modules.artistbookongfour.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.squareup.picasso.Picasso
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityArtistBookongFourBinding
import com.starmakers.app.modules.artistbookongfour.`data`.model.Listrectangle114RowModel
import com.starmakers.app.modules.artistbookongfour.`data`.viewmodel.ArtistBookongFourVM
import com.starmakers.app.responses.BookingResponse
import com.starmakers.app.responses.ProfileData
import com.starmakers.app.responses.ProfileResponseList
import com.starmakers.app.service.ApiManager
import com.starmakers.app.service.CircleTransformation
import com.starmakers.app.service.SessionManager
import retrofit2.Call
import retrofit2.Response
import kotlin.Int
import kotlin.String
import kotlin.Unit

class ArtistBookongFourActivity :
    BaseActivity<ActivityArtistBookongFourBinding>(R.layout.activity_artist_bookong_four) {
  private val viewModel: ArtistBookongFourVM by viewModels<ArtistBookongFourVM>()

  private lateinit var sessionManager: SessionManager
  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    sessionManager=SessionManager(this)

    val profileDataId = intent.getIntExtra("profileDataId", -1) // Use a default value if needed

    fetchData(profileDataId)


    val listrectangle113Adapter =
    Listrectangle113Adapter(viewModel.listrectangle113List.value?:mutableListOf())
    binding.recyclerListrectangle113.adapter = listrectangle113Adapter
    listrectangle113Adapter.setOnItemClickListener(
    object : Listrectangle113Adapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : Listrectangle114RowModel) {
        onClickRecyclerListrectangle113(view, position, item)
      }
    }
    )
    viewModel.listrectangle113List.observe(this) {
      listrectangle113Adapter.updateData(it)
    }
    binding.artistBookongFourVM = viewModel
    window.statusBarColor= ContextCompat.getColor(this,R.color.statusbar2)

  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  fun onClickRecyclerListrectangle113(
    view: View,
    position: Int,
    item: Listrectangle114RowModel
  ): Unit {
    when(view.id) {
    }
  }

  private fun fetchData(profileDataId: Int) {
    val serviceGenerator= ApiManager.apiInterface
    val accessToken=sessionManager.fetchAuthToken()
    val authorization="Token $accessToken"
    val call=serviceGenerator.getArtistlistItem(authorization,profileDataId)

    call.enqueue(object : retrofit2.Callback<ProfileData>{
      override fun onResponse(
        call: Call<ProfileData>,
        response: Response<ProfileData>
      ) {
       // val customerResponse= response.body()

        if (response.body() != null) {
          binding.txtName1.text = response.body()!!.artistName
        }

//          binding.txtAge1.text = customerResponse.age.toString()
//          binding.txtHeight1.text = customerResponse.height
//          binding.txtWeight1.text = customerResponse.weight
//          binding.txtNatureofArtis1.text = customerResponse.chooseActingField
//          binding.txtExperience1.text = customerResponse.totalExperience
//          binding.txtTotalnumberof1.text = customerResponse.totalNoOfMovies.toString()
//          binding.txtContactNumber.text = customerResponse.mobileNumber

          // Load profile picture using Picasso (similar to your existing code)
//          Picasso.get().load(customerResponse.artistPictures[0].artistPicture)
//            .transform(CircleTransformation())
//            .placeholder(R.drawable.img_ellipse32)
//            .into(binding.imageRectangle112)

      }

      override fun onFailure(call: Call<ProfileData>, t: Throwable) {
        t.printStackTrace()
        Log.e("error", t.message.toString())
      }
    })
  }

  companion object {
    const val TAG: String = "ARTIST_BOOKONG_FOUR_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, ArtistBookongFourActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}

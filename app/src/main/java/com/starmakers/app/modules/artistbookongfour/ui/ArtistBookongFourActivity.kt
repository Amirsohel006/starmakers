package com.starmakers.app.modules.artistbookongfour.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityArtistBookongFourBinding
import com.starmakers.app.modules.artistbookongfour.`data`.model.Listrectangle114RowModel
import com.starmakers.app.modules.artistbookongfour.`data`.viewmodel.ArtistBookongFourVM
import com.starmakers.app.responses.BookingResponseList
import com.starmakers.app.service.ApiManager
import com.starmakers.app.service.SessionManager
import retrofit2.Call
import retrofit2.Response
import kotlin.Int
import kotlin.String
import kotlin.Unit

class ArtistBookongFourActivity :
    BaseActivity<ActivityArtistBookongFourBinding>(R.layout.activity_artist_bookong_four) {
  private val viewModel: ArtistBookongFourVM by viewModels<ArtistBookongFourVM>()

  //private var bookingResponseList: List<BookingResponseList> = mutableListOf()
  private lateinit var sessionManager: SessionManager
  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    sessionManager=SessionManager(this)

    val profileDataId = intent.getIntExtra("profileDataId", -1) // Use a default value if needed

    fetchData(profileDataId)

    // Inside your ArtistBookongFourActivity's onInitialized() method

// Assuming you have a list of BookingResponse objects named bookingResponseList
//    val adapter = Listrectangle113Adapter(bookingResponseList)
//    binding.recyclerListrectangle113.adapter = adapter


   // binding.recyclerListrectangle113.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)


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
    val serviceGenerator = ApiManager.apiInterface
    val accessToken = sessionManager.fetchAuthToken()
    val authorization = "Token $accessToken"
    val call = serviceGenerator.getArtistlistItem(authorization, profileDataId)
    val recyclerView:RecyclerView=binding.recyclerListrectangle113

    call.enqueue(object : retrofit2.Callback<BookingResponseList> {
      override fun onResponse(
        call: Call<BookingResponseList>,
        response: Response<BookingResponseList>
      ) {

        // Make the API request with the selected acting field and category

        if (response.isSuccessful) {
          val profileResponse = response.body()
          if ((profileResponse != null) && (profileResponse.status == "success")) {
            val json = response.body().toString()
            Log.d("Response JSON", json)
            val profileData = response.body()

            if (profileData != null) {
              binding.txtName1.text = profileData.data.artistName
              binding.txtAge1.text=profileData.data.age.toString()
              binding.txtHeight1.text=profileData.data.weight
              binding.txtWeight1.text=profileData.data.height
              binding.txtNatureofArtis1.text=profileData.data.chooseActingField
              binding.txtExperience1.text=profileData.data.totalExperience
              binding.txtTotalnumberof1.text=profileData.data.totalNoOfMovies.toString()
              binding.txtContactNumber1.text=profileData.data.mobileNumber

              val imageview:ImageView=binding.imageRectangle112
              Picasso.get()
                .load(profileData.data.artistPictures[0].artistPicture)
                .into(imageview)

              recyclerView.apply {

                 layoutManager = LinearLayoutManager(this@ArtistBookongFourActivity, LinearLayoutManager.HORIZONTAL, false)
                val tarologersListAdapter =
                  Listrectangle113Adapter(listOf(response.body()!!))
                recyclerView.adapter=tarologersListAdapter
              }

            }
          } else {

            // Handle API error here
            Toast.makeText(
              this@ArtistBookongFourActivity,
              "API error: ${response.code()}",
              Toast.LENGTH_SHORT
            ).show()
          }
        }
      }


      override fun onFailure(call: Call<BookingResponseList>, t: Throwable) {
        t.printStackTrace()
        Log.e("error", t.message.toString())
      }
    })


  }

























//    val serviceGenerator= ApiManager.apiInterface
//    val accessToken=sessionManager.fetchAuthToken()
//    val authorization="Token $accessToken"
//    val call=serviceGenerator.getArtistlistItem(authorization,profileDataId)
//
//    call.enqueue(object : retrofit2.Callback<ProfileData>{
//      override fun onResponse(
//        call: Call<ProfileData>,
//        response: Response<ProfileData>
//      ) {
//        val json = response.body().toString() // Convert response body to JSON string
//        Log.d("Response JSON", json)
//        val profileData:ProfileData = response.body()!!
//
//
//        if (profileData != null) {
//          binding.txtName1.text = profileData.artistName
//        }
//
////          binding.txtAge1.text = customerResponse.age.toString()
////          binding.txtHeight1.text = customerResponse.height
////          binding.txtWeight1.text = customerResponse.weight
////          binding.txtNatureofArtis1.text = customerResponse.chooseActingField
////          binding.txtExperience1.text = customerResponse.totalExperience
////          binding.txtTotalnumberof1.text = customerResponse.totalNoOfMovies.toString()
////          binding.txtContactNumber.text = customerResponse.mobileNumber
//
//          // Load profile picture using Picasso (similar to your existing code)
////          Picasso.get().load(customerResponse.artistPictures[0].artistPicture)
////            .transform(CircleTransformation())
////            .placeholder(R.drawable.img_ellipse32)
////            .into(binding.imageRectangle112)
//
//      }
//
//      override fun onFailure(call: Call<ProfileData>, t: Throwable) {
//        t.printStackTrace()
//        Log.e("error", t.message.toString())
//      }
//    })


  companion object {
    const val TAG: String = "ARTIST_BOOKONG_FOUR_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, ArtistBookongFourActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}

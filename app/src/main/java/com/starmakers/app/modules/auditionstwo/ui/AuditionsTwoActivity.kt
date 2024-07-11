package com.starmakers.app.modules.auditionstwo.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityAuditionsTwoBinding
import com.starmakers.app.modules.auditionstwo.`data`.model.AuditionsTwoRowModel
import com.starmakers.app.modules.auditionstwo.`data`.viewmodel.AuditionsTwoVM
import com.starmakers.app.responses.MyStudioRequest
import com.starmakers.app.service.ApiManager
import com.starmakers.app.service.SessionManager
import retrofit2.Call
import retrofit2.Response
import kotlin.Int
import kotlin.String
import kotlin.Unit

class AuditionsTwoActivity :
    BaseActivity<ActivityAuditionsTwoBinding>(R.layout.activity_auditions_two) {
  private val viewModel: AuditionsTwoVM by viewModels<AuditionsTwoVM>()

  private lateinit var sessionManager: SessionManager

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")


    sessionManager=SessionManager(this)

    val studioId = intent.getIntExtra("studioId", -1)
    getMyStudioRequests(studioId)

   /* val auditionsTwoAdapter =
    AuditionsTwoAdapter(viewModel.auditionsTwoList.value?:mutableListOf())
    binding.recyclerAuditionsTwo.adapter = auditionsTwoAdapter
    auditionsTwoAdapter.setOnItemClickListener(
    object : AuditionsTwoAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : AuditionsTwoRowModel) {
        onClickRecyclerAuditionsTwo(view, position, item)
      }
    }
    )
    viewModel.auditionsTwoList.observe(this) {
      auditionsTwoAdapter.updateData(it)
    }*/
    binding.auditionsTwoVM = viewModel
    window.statusBarColor= ContextCompat.getColor(this,R.color.statusbar2)
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
//    binding.btnRequestStudio.setOnClickListener {
//      val destIntent = Frame316Activity.getIntent(this, null)
//      startActivity(destIntent)
//    }
  }


  private fun getMyStudioRequests(studioId: Int) {
    val serviceGenerator = ApiManager.apiInterface
    val accessToken = sessionManager.fetchAuthToken()
    val authorization = "Token $accessToken"
    val call = serviceGenerator.getMyStudioRequest(authorization, studioId)

    call.enqueue(object : retrofit2.Callback<MyStudioRequest> {
      @SuppressLint("SetTextI18n")
      override fun onResponse(call: Call<MyStudioRequest>, response: Response<MyStudioRequest>) {
        val customerResponse = response.body()

        // Define the corner radius in pixels (converted from dp)
        val cornerRadiusInPixels = 15 // Change to your dimension resource

        // Create a RequestOptions object with the RoundedCorners transformation
        val requestOptions = RequestOptions()
          .transform(RoundedCorners(cornerRadiusInPixels))

        if (customerResponse != null && customerResponse.status == "success") {
          val studioModel = response.body()
          if (studioModel != null) {
            binding.txtName1.text = studioModel.data.studio_name
            binding.txtYear1.text = studioModel.data.date_of_start
            binding.txtDescription.text = studioModel.data.write_about_studio

            binding.txtRamamandStudio.text = studioModel.data.studio_name

            val bookButton = binding.btnRequestStudio
            val studioBooking = studioModel.data.studio_booking

            if (studioBooking.isNotEmpty()) {
              val isBooked = studioBooking[0].booking_studio
              bookButton.text = if (isBooked == "pending") "Pending" else "Booked"
            } else {
              bookButton.text = "Available to Book"
            }

            if (studioModel.data.studio_picture.isNotEmpty()) {
              val file = studioModel.data.studio_picture[0].studio_picture
              val imgUrl = file.let { ApiManager.getImageUrl(it) }

              Glide.with(this@AuditionsTwoActivity)
                .load(imgUrl) // Replace with your image URL or resource ID
                .apply(requestOptions)
                .into(binding.imageRectangleNineteen)
            } else {
              // Handle the case when postModel.studio_picture is empty
              // You might want to set a default value or display a message to the user
            }

            binding.recyclerAuditionsTwo.apply {
              layoutManager =
                LinearLayoutManager(this@AuditionsTwoActivity, LinearLayoutManager.HORIZONTAL, false)
              val adapter = AuditionsTwoAdapter(studioModel.data.studio_movie)
              binding.recyclerAuditionsTwo.adapter = adapter
            }
          }
        }
      }

      override fun onFailure(call: Call<MyStudioRequest>, t: Throwable) {
        t.printStackTrace()
        Log.e("error", t.message.toString())
      }
    })
  }




  fun onClickRecyclerAuditionsTwo(
    view: View,
    position: Int,
    item: AuditionsTwoRowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "AUDITIONS_TWO_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, AuditionsTwoActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}

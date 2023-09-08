package com.starmakers.app.modules.auditionsfour.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityAuditionsFourBinding
import com.starmakers.app.modules.artistbookongfour.ui.Listrectangle113Adapter
import com.starmakers.app.modules.artistmembership.data.model.SpinnerComponentOneModel
import com.starmakers.app.modules.auditions.ui.AuditionsAdapter
import com.starmakers.app.modules.auditionsfour.`data`.model.SpinnerComponentNineModel
import com.starmakers.app.modules.auditionsfour.`data`.viewmodel.AuditionsFourVM
import com.starmakers.app.modules.frametwentythree.ui.FrameTwentythreeActivity
import com.starmakers.app.responses.Audition
import com.starmakers.app.responses.AuditionPosition
import com.starmakers.app.responses.PostReponses
import com.starmakers.app.responses.RequestAudition
import com.starmakers.app.responses.RequestUserData
import com.starmakers.app.service.ApiManager
import com.starmakers.app.service.SessionManager
import okhttp3.internal.canParseAsIpAddress
import retrofit2.Call
import retrofit2.Response
import kotlin.String
import kotlin.Unit

class AuditionsFourActivity :
    BaseActivity<ActivityAuditionsFourBinding>(R.layout.activity_auditions_four) {
  private val viewModel: AuditionsFourVM by viewModels<AuditionsFourVM>()



  private lateinit var sessionManager: SessionManager
  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    sessionManager=SessionManager(this)



    val profileDataId = intent.getIntExtra("artistDataId",-1)
    val serviceGenerator= ApiManager.apiInterface
    val accessToken=sessionManager.fetchAuthToken()
    val authorization="Token $accessToken"
    val call=serviceGenerator.requestPosition(authorization,profileDataId)

    call.enqueue(object : retrofit2.Callback<MutableList<AuditionPosition>>{
      override fun onResponse(
        call: Call<MutableList<AuditionPosition>>,
        response: Response<MutableList<AuditionPosition>>
      ) {
        val auditionPositions = response.body()
        if (auditionPositions != null) {
          val spinnerItems = auditionPositions.map { it.audition_positions }.toMutableList()
          spinnerItems.add(0, "Applying for this role")


          // Assuming you have a reference to your Spinner view
          val spinner = findViewById<Spinner>(R.id.spinnerComponentNine)

          // Create an ArrayAdapter to populate the Spinner
          val adapter = ArrayAdapter<String>(
            this@AuditionsFourActivity, // Replace with your actual activity reference
            android.R.layout.simple_spinner_item,
            spinnerItems
          )

          // Set the dropdown layout style
          adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

          // Set the adapter on the Spinner
          spinner.adapter = adapter

          // Optionally, set an item selected listener if needed
          spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
              parent: AdapterView<*>?,
              view: View?,
              position: Int,
              id: Long
            ) {
              // Handle item selection here if needed
              val selectedValue = spinnerItems[position]
              // Do something with the selected value
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
              // Handle case when nothing is selected
            }
          }
        }
      }


      override fun onFailure(call: Call<MutableList<AuditionPosition>>, t: Throwable) {
        t.printStackTrace()
        Log.e("error", t.message.toString())
      }
    })

   binding.auditionsFourVM = viewModel


    fetchData()
    window.statusBarColor= ContextCompat.getColor(this,R.color.statusbar2)

  }

  override fun setUpClicks(): Unit {
    binding.btnParticipate.setOnClickListener {
      val destIntent = FrameTwentythreeActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }




 /* private fun postResponses(){
    val serviceGenerator= ApiManager.apiInterface
    val accessToken=sessionManager.fetchAuthToken()
    val authorization="Token $accessToken"
    val call=serviceGenerator.PostResponses(authorization)

    call.enqueue(object : retrofit2.Callback<PostReponses>{
      override fun onResponse(
        call: Call<PostReponses>,
        response: Response<PostReponses>
      ) {
        val customerResponse=response.body()

        if(customerResponse!=null){

        }
      }

      override fun onFailure(call: Call<PostReponses>, t: Throwable) {
        t.printStackTrace()
        Log.e("error", t.message.toString())
      }
    })
  }*/

  private fun fetchData(){
    val serviceGenerator= ApiManager.apiInterface
    val accessToken=sessionManager.fetchAuthToken()
    val authorization="Token $accessToken"
    val call=serviceGenerator.requestAudition(authorization)

    call.enqueue(object : retrofit2.Callback<RequestAudition>{
      override fun onResponse(
        call: Call<RequestAudition>,
        response: Response<RequestAudition>
      ) {
        val customerResponse=response.body()

        if(customerResponse!=null){
          binding.etName.text=customerResponse.data.name
          binding.etmobileNumber.text=customerResponse.data.mobile_number
          binding.etAge1.text=customerResponse.data.age
          binding.etHeight1.text=customerResponse.data.height
          binding.etWeight.text=customerResponse.data.weight

        }
      }

      override fun onFailure(call: Call<RequestAudition>, t: Throwable) {
        t.printStackTrace()
        Log.e("error", t.message.toString())
      }
    })
  }


  companion object {
    const val TAG: String = "AUDITIONS_FOUR_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, AuditionsFourActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}

package com.starmakers.app.modules.artistbookongfive.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.google.gson.Gson
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityArtistBookongFiveBinding
import com.starmakers.app.modules.artistbookongfive.`data`.model.SpinnerComponentEightModel
import com.starmakers.app.modules.artistbookongfive.`data`.viewmodel.ArtistBookongFiveVM
import com.starmakers.app.modules.artistbookongtwo.ui.ArtistBookongTwoActivity
import com.starmakers.app.responses.CategoryItem
import com.starmakers.app.responses.ProfileResponseList
import com.starmakers.app.service.ApiManager
import com.starmakers.app.service.CircleTransformation
import com.starmakers.app.service.SessionManager
import com.starmakers.app.responses.MyAuditionRequest
import org.koin.android.ext.android.get
import retrofit2.Call
import retrofit2.Response
import kotlin.String
import kotlin.Unit

class ArtistBookongFiveActivity :
    BaseActivity<ActivityArtistBookongFiveBinding>(R.layout.activity_artist_bookong_five) {
  private val viewModel: ArtistBookongFiveVM by viewModels<ArtistBookongFiveVM>()


  private lateinit var sessionManager: SessionManager
  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    sessionManager=SessionManager(this)


    getCategory()
    viewModel.spinnerComponentEightList.value = mutableListOf(
    SpinnerComponentEightModel("Choose Acting Field"),
    SpinnerComponentEightModel("Movies"),
    SpinnerComponentEightModel("Serials"),
    )
    val spinnerComponentEightAdapter =
    SpinnerComponentEightAdapter(this,R.layout.spinner_item,viewModel.spinnerComponentEightList.value?:
    mutableListOf())
    binding.spinnerComponentEight.adapter = spinnerComponentEightAdapter
  /*  viewModel.spinnerComponentOneList.value =
      mutableListOf(
      SpinnerComponentOneModel("Select Category"),
      SpinnerComponentOneModel("Actors"),
      SpinnerComponentOneModel("Actress"),
      SpinnerComponentOneModel("Director"),
      SpinnerComponentOneModel("Assistant Director"),
      SpinnerComponentOneModel("Associate Director"),
      SpinnerComponentOneModel("Cameraman"),
      SpinnerComponentOneModel("Story Writer"),
      SpinnerComponentOneModel("Dialogue Writer"),
      SpinnerComponentOneModel("Singer"),
      SpinnerComponentOneModel("Supporting Singer"),
      SpinnerComponentOneModel("Fight Master"),
      SpinnerComponentOneModel("Dance Master"),
      SpinnerComponentOneModel("Dancer"),
      SpinnerComponentOneModel("Fighter"),
      SpinnerComponentOneModel("Still Photographer"),
      SpinnerComponentOneModel("Makeup Man"),
      SpinnerComponentOneModel("Hair Stylist"),
      SpinnerComponentOneModel("Costume Designer"),
      SpinnerComponentOneModel("Dubbing Artist"),
      SpinnerComponentOneModel("Artist Personal Assistant"),
      SpinnerComponentOneModel("Artist Personal Body Guard"),
      SpinnerComponentOneModel("Artist Personal Manager"),
      SpinnerComponentOneModel("Production Manager"),
      SpinnerComponentOneModel("Spot Boy"),
      SpinnerComponentOneModel("Set Artist/Worker")
    )
    val spinnerComponentOneAdapter =
    SpinnerComponentOneAdapter(this,R.layout.spinner_item,viewModel.spinnerComponentOneList.value?:
    mutableListOf())
    binding.spinnerComponentOne.adapter = spinnerComponentOneAdapter*/
    binding.artistBookongFiveVM = viewModel


    binding.btnSearch.setOnClickListener {
      val actingField = binding.spinnerComponentEight.selectedItem as SpinnerComponentEightModel
      val category = binding.spinnerComponentOne.selectedItem as String


      if (actingField.itemName != "Choose Acting Field" && category != "Select Category"){

        val serviceGenerator= ApiManager.apiInterface
        val accessToken=sessionManager.fetchAuthToken()
        val authorization="Token $accessToken"
        val call=serviceGenerator.getArtistlist(authorization,actingField.itemName,category)

        call.enqueue(object : retrofit2.Callback<ProfileResponseList>{
          override fun onResponse(
            call: Call<ProfileResponseList>,
            response: Response<ProfileResponseList>
          ) {

            // Make the API request with the selected acting field and category

            if (response.isSuccessful) {
              val profileResponse = response.body()
              if ((profileResponse != null) && (profileResponse.status == "success")) {

                val artists = profileResponse.data
                val gson = Gson()
                val profileDataJson = gson.toJson(artists)

                val intent = Intent(this@ArtistBookongFiveActivity, ArtistBookongTwoActivity::class.java)
                intent.putExtra("artists",profileDataJson)
                startActivity(intent)
              } else {
                // Handle API response error here
                Toast.makeText(
                  this@ArtistBookongFiveActivity,
                  "API response error",
                  Toast.LENGTH_SHORT
                ).show()
              }
            } else {
              // Handle API error here
              Toast.makeText(
                this@ArtistBookongFiveActivity,
                "API error: ${response.code()}",
                Toast.LENGTH_SHORT
              ).show()
            }
          }


          override fun onFailure(call: Call<ProfileResponseList>, t: Throwable) {
            t.printStackTrace()
            Log.e("error", t.message.toString())
          }
        })
      } else {
        // Show an error message to the user indicating invalid selections
        Toast.makeText(this, "Please select both Acting Field and Category", Toast.LENGTH_SHORT).show()
      }


    }

    window.statusBarColor= ContextCompat.getColor(this,R.color.statusbar2)
  }

  override fun setUpClicks(): Unit {
//    binding.btnSearch.setOnClickListener {
//      val destIntent = ArtistBookongTwoActivity.getIntent(this, null)
//      startActivity(destIntent)
//    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }


  fun getCategory(){
    val serviceGenerator= ApiManager.apiInterface
    val accessToken=sessionManager.fetchAuthToken()
    val authorization="Token $accessToken"
    val call=serviceGenerator.getCategory(authorization)
    call.enqueue(object : retrofit2.Callback<MutableList<CategoryItem>> {
      override fun onResponse(
        call: Call<MutableList<CategoryItem>>,
        response: Response<MutableList<CategoryItem>>
      ) {
        if(response.isSuccessful){
          val categoryItems = response.body()

          val spinnerItems = categoryItems?.map { it.category_name }?.toMutableList()
          spinnerItems!!.add(0, "Applying for this role")
          val spinner = findViewById<Spinner>(R.id.spinnerComponentOne)

          val adapter = ArrayAdapter<String>(
            this@ArtistBookongFiveActivity, // Replace with your actual activity reference
            android.R.layout.simple_spinner_item,
            spinnerItems
          )


          adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
          spinner.adapter = adapter

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


                   //viewModel.spinnerComponentOneList.value(categoryItems)
        }


      }

      override fun onFailure(call: Call<MutableList<CategoryItem>>, t: Throwable) {
      }
    })
  }

  companion object {
    const val TAG: String = "ARTIST_BOOKONG_FIVE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, ArtistBookongFiveActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}

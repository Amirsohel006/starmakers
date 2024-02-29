package com.starmakers.app.modules.artistbookongone.ui

import android.content.Intent
import android.util.Log
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.squareup.picasso.Picasso
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityArtistBookongOneBinding
import com.starmakers.app.modules.artistbookongone.`data`.viewmodel.ArtistBookongOneVM
import com.starmakers.app.modules.artistmembership.ui.ArtistMembershipActivity
import com.starmakers.app.modules.artistmembershipone.ui.ArtistMembershipOneActivity
import com.starmakers.app.modules.membershipoptioncomingsoon.ComingSoon
import com.starmakers.app.modules.profleupdate.ProfileUpdate
import com.starmakers.app.modules.signuotwo.ui.LoginActivity
import com.starmakers.app.responses.LogoutResponse
import com.starmakers.app.responses.ProfileResponse
import com.starmakers.app.responses.RequestAudition
import com.starmakers.app.service.ApiManager
import com.starmakers.app.service.CircleTransformation
import com.starmakers.app.service.SessionManager
import retrofit2.Call
import retrofit2.Response
import kotlin.String
import kotlin.Unit

class ArtistBookongOneActivity :
    BaseActivity<ActivityArtistBookongOneBinding>(R.layout.activity_artist_bookong_one) {
  private val viewModel: ArtistBookongOneVM by viewModels<ArtistBookongOneVM>()


  private lateinit var sessionManager: SessionManager


  private var name:String=""
  private var mobileNumber:String=""
  private var email:String=""
  private var height:String=""
  private var weight:String=""
  private var profile_picture:String=""
  private var chooseLocation:String=""
  override fun onInitialized(): Unit {
    sessionManager= SessionManager(this)
    viewModel.navArguments = intent.extras?.getBundle("bundle")


    fetchData()
    binding.artistBookongOneVM = viewModel
    window.statusBarColor= ContextCompat.getColor(this,R.color.statusbar2)
  }

  override fun setUpClicks(): Unit {
    binding.btnLogout.setOnClickListener {
      logout()
    }
    binding.btnTakeMembershipOne.setOnClickListener {
      //val destIntent = ArtistMembershipActivity.getIntent(this, null)
      val destIntent = Intent(this,ComingSoon::class.java)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }

    binding.editText.setOnClickListener {
      val i=Intent(this,ProfileUpdate::class.java)
//      i.putExtra("name",name)
//      i.putExtra("mobile_number",mobileNumber)
//      i.putExtra("email",email)
//      i.putExtra("height",height)
//      i.putExtra("weight",weight)
//      i.putExtra("profile",profile_picture)
//     //Log.d("ProfileImage",profile_picture.toString())
//      i.putExtra("city",chooseLocation)
      startActivity(i)
    }
  }


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

          // Check if artistPictures is not null and not empty
          if (!customerResponse.data.artistPictures.isNullOrEmpty()) {
            // Load the first artist picture if available
            val profilePicture: ImageView = binding.profilepicturerounded
            val image = customerResponse.data.artistPictures[0].artistPicture
            binding.etName.text=customerResponse.data.artistName
            binding.etMobileNumber.text=customerResponse.data.phoneNumber
            binding.etLocation.text=customerResponse.data.location
            val file = ApiManager.getImageUrl(image!!)
            Picasso.get().load(file).transform(CircleTransformation()).placeholder(R.drawable.img_ellipse32).into(profilePicture)
          } else {
            // Check if profile picture is not empty
            val profilePicture: ImageView = binding.profilepicturerounded
            val image = customerResponse.data.profile

            binding.etName.text=customerResponse.data.name
            binding.etMobileNumber.text=customerResponse.data.mobile_number
            binding.etEmail.text=customerResponse.data.email
            binding.etHeight1.text=customerResponse.data.height
            binding.etWeight1.text=customerResponse.data.weight
            binding.etLocation.text=customerResponse.data.city
            if (!image.isNullOrEmpty()) {
              val file = ApiManager.getImageUrl(image)
              Picasso.get().load(file).transform(CircleTransformation()).placeholder(R.drawable.img_ellipse32).into(profilePicture)
            } else {
              // Load a default picture if both artistPictures and profile are empty
              Picasso.get().load(R.drawable.default_profile_pic).transform(CircleTransformation()).placeholder(R.drawable.img_ellipse32).into(profilePicture)
            }
          }



          Picasso.get().load(customerResponse.data.profile).transform(CircleTransformation()).into(binding.profilepicturerounded)
        }
      }

      override fun onFailure(call: Call<RequestAudition>, t: Throwable) {
        t.printStackTrace()
        Log.e("error", t.message.toString())
      }
    })
  }


  fun logout(){
    val serviceGenerator= ApiManager.apiInterface
    val accessToken=sessionManager.fetchAuthToken()
    val authorization="Token $accessToken"
    val call=serviceGenerator.logout(authorization)

    call.enqueue(object : retrofit2.Callback<LogoutResponse>{
      override fun onResponse(
        call: Call<LogoutResponse>,
        response: Response<LogoutResponse>
      ) {
        val logoutResponse=response.body()

        if(logoutResponse!=null){
          Toast.makeText(this@ArtistBookongOneActivity,"Logout Successful", Toast.LENGTH_SHORT).show()
          sessionManager.logout()
          sessionManager.clearSession()
          redirectToLoginActivity()
        }
      }

      override fun onFailure(call: Call<LogoutResponse>, t: Throwable) {
        t.printStackTrace()
        Log.e("error", t.message.toString())
      }
    })
  }


  private fun redirectToLoginActivity(){
    val intent = Intent(this, LoginActivity::class.java)
    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    ActivityCompat.finishAffinity(this)
    startActivity(intent)
  }
  companion object {
    const val TAG: String = "ARTIST_BOOKONG_ONE_ACTIVITY"

  }
}

package com.starmakers.app.modules.frame311.ui

import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.squareup.picasso.Picasso
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityFrame311Binding
import com.starmakers.app.modules.artistbookong.ui.ArtistBookongActivity
import com.starmakers.app.modules.artistmembership.ui.ArtistMembershipActivity
import com.starmakers.app.modules.auditionsthree.ui.AuditionsThreeActivity
import com.starmakers.app.modules.frame311.`data`.viewmodel.Frame311VM
import com.starmakers.app.modules.help.ui.HelpActivity
import com.starmakers.app.modules.helpone.ui.HelpOneActivity
import com.starmakers.app.modules.helptwo.ui.HelpTwoActivity
import com.starmakers.app.modules.membershipoptioncomingsoon.ComingSoon
import com.starmakers.app.modules.selectionlist.ui.SelectionListActivity
import com.starmakers.app.modules.selectionlistone.ui.SelectionListOneActivity
import com.starmakers.app.modules.selectionlistthree.ui.SelectionListThreeActivity
import com.starmakers.app.responses.ProfileResponse
import com.starmakers.app.service.ApiManager
import com.starmakers.app.service.CircleTransformation
import com.starmakers.app.service.SessionManager
import retrofit2.Call
import retrofit2.Response
import kotlin.String
import kotlin.Unit

class Frame311Activity : BaseActivity<ActivityFrame311Binding>(R.layout.activity_frame_311) {
  private val viewModel: Frame311VM by viewModels<Frame311VM>()

  private lateinit var sessionManager: SessionManager
  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.frame311VM = viewModel

    sessionManager=SessionManager(this)

    fetchData()
    window.statusBarColor= ContextCompat.getColor(this,R.color.statusbar2)
  }

  override fun setUpClicks(): Unit {

    binding.imageMenu.setOnClickListener {
      this.finish()
    }

    binding.linearRowgroup.setOnClickListener {
      val destIntent = SelectionListThreeActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowreply.setOnClickListener {
      val destIntent = AuditionsThreeActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRownotification.setOnClickListener {
      val destIntent = SelectionListActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowinfo.setOnClickListener {
      val destIntent = HelpOneActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowcomputer.setOnClickListener {
      val i= Intent(this, ArtistMembershipActivity::class.java)
      startActivity(i)
     //val destIntent = ArtistMembershipActivity.getIntent(this, null)
//      startActivity(destIntent)
    }
    binding.linearRowquestion.setOnClickListener {
      val destIntent = HelpActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.txtRahul.setOnClickListener {
      val destIntent = ArtistBookongActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowinfoOne.setOnClickListener {
      val destIntent = HelpTwoActivity.getIntent(this, null)
      startActivity(destIntent)
    }

    binding.linearRowshare.setOnClickListener {
      Toast.makeText(this,"This Feature Will Be Available Soon",Toast.LENGTH_SHORT).show()
    }


    binding.linearRowcalculator.setOnClickListener {
      val i=Intent(this, SelectionListOneActivity::class.java)
      startActivity(i)
    }
  }


  private fun fetchData(){
    val serviceGenerator = ApiManager.apiInterface
    val accessToken = sessionManager.fetchAuthToken()
    val authorization = "Token $accessToken"
    val call = serviceGenerator.getProfile(authorization)

    call.enqueue(object : retrofit2.Callback<ProfileResponse>{
      override fun onResponse(
        call: Call<ProfileResponse>,
        response: Response<ProfileResponse>
      ) {
        val customerResponse = response.body()

        if(customerResponse != null) {

          binding.txtMobileNo.text=customerResponse.mobileNumber
          binding.txtEmail.text=customerResponse.email

          sessionManager.saveuserId(customerResponse.id.toString())

          // Check if artistPictures is not null and not empty
          if (!customerResponse.artistName.isNullOrEmpty()) {
            // Load the first artist picture if available
            binding.txtRahul.text=customerResponse.artistName
            val profilePicture: ImageView = binding.profilePicture
            binding.btnMemberactor.visibility= View.VISIBLE
            val artistPictures = customerResponse.artistPictures
            if (artistPictures.isNotEmpty()) {
              val image = artistPictures[0].artistPicture
              if (image != null) {
                Picasso.get().load(image).transform(CircleTransformation()).placeholder(R.drawable.img_ellipse32).into(profilePicture)
              }
            } else {
              Toast.makeText(this@Frame311Activity,"Profile Pic Not Available",Toast.LENGTH_SHORT).show()
            }
          } else {
            // Check if profile picture is not empty
            binding.txtRahul.text = customerResponse.name
            val profilePicture: ImageView = binding.profilePicture
            val image = customerResponse.profile
            binding.btnMemberactor.visibility= View.GONE
            if (!image.isNullOrEmpty()) {
              val file = ApiManager.getImageUrl(image)
              Picasso.get().load(file).transform(CircleTransformation()).placeholder(R.drawable.img_ellipse32).into(profilePicture)
            } else {
              // Load a default picture if both artistPictures and profile are empty
              Picasso.get().load(R.drawable.default_profile_pic).transform(CircleTransformation()).placeholder(R.drawable.img_ellipse32).into(profilePicture)
            }
          }
        }
      }

      override fun onFailure(call: Call<ProfileResponse>, t: Throwable) {
        t.printStackTrace()
        Log.e("error", t.message.toString())
      }
    })
  }

  companion object {
    const val TAG: String = "FRAME311ACTIVITY"

  }
}

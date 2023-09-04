package com.starmakers.app.modules.artistbookongone.ui

import android.util.Log
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.squareup.picasso.Picasso
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityArtistBookongOneBinding
import com.starmakers.app.modules.artistbookongone.`data`.viewmodel.ArtistBookongOneVM
import com.starmakers.app.modules.artistmembership.ui.ArtistMembershipActivity
import com.starmakers.app.modules.artistmembershipone.ui.ArtistMembershipOneActivity
import com.starmakers.app.modules.signuotwo.ui.LoginActivity
import com.starmakers.app.responses.ProfileResponse
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
  override fun onInitialized(): Unit {
    sessionManager= SessionManager(this)
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.artistBookongOneVM = viewModel
    window.statusBarColor= ContextCompat.getColor(this,R.color.statusbar2)
  }

  override fun setUpClicks(): Unit {
    binding.btnLogout.setOnClickListener {
      val destIntent = LoginActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnTakeMembershipOne.setOnClickListener {
      val destIntent = ArtistMembershipActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }



  companion object {
    const val TAG: String = "ARTIST_BOOKONG_ONE_ACTIVITY"

  }
}

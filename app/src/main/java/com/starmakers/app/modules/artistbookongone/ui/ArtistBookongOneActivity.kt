package com.starmakers.app.modules.artistbookongone.ui

import androidx.activity.viewModels
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityArtistBookongOneBinding
import com.starmakers.app.modules.artistbookongone.`data`.viewmodel.ArtistBookongOneVM
import com.starmakers.app.modules.artistmembershipone.ui.ArtistMembershipOneActivity
import com.starmakers.app.modules.signuotwo.ui.SignUoTwoActivity
import kotlin.String
import kotlin.Unit

class ArtistBookongOneActivity :
    BaseActivity<ActivityArtistBookongOneBinding>(R.layout.activity_artist_bookong_one) {
  private val viewModel: ArtistBookongOneVM by viewModels<ArtistBookongOneVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.artistBookongOneVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnLogout.setOnClickListener {
      val destIntent = SignUoTwoActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnTakeMembershipOne.setOnClickListener {
      val destIntent = ArtistMembershipOneActivity.getIntent(this, null)
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

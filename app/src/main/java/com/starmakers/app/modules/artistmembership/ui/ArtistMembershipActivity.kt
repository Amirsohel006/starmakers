package com.starmakers.app.modules.artistmembership.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.modules.artistbookongfour.ui.ArtistBookongFourActivity
import com.starmakers.app.modules.artistmembership.`data`.model.SpinnerComponentOneModel
import com.starmakers.app.modules.artistmembership.`data`.model.SpinnerComponentSevenModel
import com.starmakers.app.modules.artistmembership.`data`.viewmodel.ArtistMembershipVM
import com.starmakers.app.modules.regstrationdetails.ui.RegstrationDetailsActivity
import kotlin.String
import kotlin.Unit

class ArtistMembershipActivity :
    BaseActivity<com.starmakers.app.databinding.ActivityArtistMembershipBinding>(R.layout.activity_artist_membership) {
  private val viewModel: ArtistMembershipVM by viewModels<ArtistMembershipVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    viewModel.spinnerComponentSevenList.value = mutableListOf(
    SpinnerComponentSevenModel("Choose Acting Field"),
    SpinnerComponentSevenModel("Movies"),
    SpinnerComponentSevenModel("Serials")
    )
    val spinnerComponentSevenAdapter =
    SpinnerComponentSevenAdapter(this,R.layout.spinner_item,viewModel.spinnerComponentSevenList.value?:
    mutableListOf())
    binding.spinnerComponentSeven.adapter = spinnerComponentSevenAdapter
    viewModel.spinnerComponentOneList.value = mutableListOf(
      SpinnerComponentOneModel("Select Category"),
    SpinnerComponentOneModel("Actor"),
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
    binding.spinnerComponentOne.adapter = spinnerComponentOneAdapter
    binding.artistMembershipVM = viewModel

    window.statusBarColor= ContextCompat.getColor(this,R.color.statusbar2)
  }

  override fun setUpClicks(): Unit {
    binding.imageRectangle110Five.setOnClickListener {
      val destIntent = ArtistBookongFourActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageRectangle110Four.setOnClickListener {
      val destIntent = ArtistBookongFourActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageRectangle110Three.setOnClickListener {
      val destIntent = ArtistBookongFourActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageRectangle110Two.setOnClickListener {
      val destIntent = ArtistBookongFourActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageRectangle110One.setOnClickListener {
      val destIntent = ArtistBookongFourActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnContinue.setOnClickListener {
      val destIntent = RegstrationDetailsActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "ARTIST_MEMBERSHIP_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, ArtistMembershipActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}

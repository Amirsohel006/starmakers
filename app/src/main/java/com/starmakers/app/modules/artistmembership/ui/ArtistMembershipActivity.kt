package com.starmakers.app.modules.artistmembership.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityArtistMembershipBinding
import com.starmakers.app.modules.artistbookongfour.ui.ArtistBookongFourActivity
import com.starmakers.app.modules.artistmembership.`data`.model.SpinnerComponentOneModel
import com.starmakers.app.modules.artistmembership.`data`.model.SpinnerComponentSevenModel
import com.starmakers.app.modules.artistmembership.`data`.viewmodel.ArtistMembershipVM
import com.starmakers.app.modules.regstrationdetails.ui.RegstrationDetailsActivity
import kotlin.String
import kotlin.Unit

class ArtistMembershipActivity :
    BaseActivity<ActivityArtistMembershipBinding>(R.layout.activity_artist_membership) {
  private val viewModel: ArtistMembershipVM by viewModels<ArtistMembershipVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    viewModel.spinnerComponentSevenList.value = mutableListOf(
    SpinnerComponentSevenModel("Item1"),
    SpinnerComponentSevenModel("Item2"),
    SpinnerComponentSevenModel("Item3"),
    SpinnerComponentSevenModel("Item4"),
    SpinnerComponentSevenModel("Item5")
    )
    val spinnerComponentSevenAdapter =
    SpinnerComponentSevenAdapter(this,R.layout.spinner_item,viewModel.spinnerComponentSevenList.value?:
    mutableListOf())
    binding.spinnerComponentSeven.adapter = spinnerComponentSevenAdapter
    viewModel.spinnerComponentOneList.value = mutableListOf(
    SpinnerComponentOneModel("Item1"),
    SpinnerComponentOneModel("Item2"),
    SpinnerComponentOneModel("Item3"),
    SpinnerComponentOneModel("Item4"),
    SpinnerComponentOneModel("Item5")
    )
    val spinnerComponentOneAdapter =
    SpinnerComponentOneAdapter(this,R.layout.spinner_item,viewModel.spinnerComponentOneList.value?:
    mutableListOf())
    binding.spinnerComponentOne.adapter = spinnerComponentOneAdapter
    binding.artistMembershipVM = viewModel
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

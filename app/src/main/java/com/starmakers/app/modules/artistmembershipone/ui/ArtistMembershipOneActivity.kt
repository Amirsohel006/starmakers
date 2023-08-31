package com.starmakers.app.modules.artistmembershipone.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityArtistMembershipOneBinding
import com.starmakers.app.modules.artistmembershipone.`data`.model.SpinnerComponentOneModel
import com.starmakers.app.modules.artistmembershipone.`data`.model.SpinnerComponentSevenModel
import com.starmakers.app.modules.artistmembershipone.`data`.viewmodel.ArtistMembershipOneVM
import com.starmakers.app.modules.artistmembershiptwo.ui.ArtistMembershipTwoActivity
import kotlin.String
import kotlin.Unit

class ArtistMembershipOneActivity :
    BaseActivity<ActivityArtistMembershipOneBinding>(R.layout.activity_artist_membership_one) {
  private val viewModel: ArtistMembershipOneVM by viewModels<ArtistMembershipOneVM>()

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
    binding.artistMembershipOneVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnContinue.setOnClickListener {
      val destIntent = ArtistMembershipTwoActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "ARTIST_MEMBERSHIP_ONE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, ArtistMembershipOneActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}

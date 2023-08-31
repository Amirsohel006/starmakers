package com.starmakers.app.modules.artistbookongfive.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityArtistBookongFiveBinding
import com.starmakers.app.modules.artistbookongfive.`data`.model.SpinnerComponentEightModel
import com.starmakers.app.modules.artistbookongfive.`data`.model.SpinnerComponentOneModel
import com.starmakers.app.modules.artistbookongfive.`data`.model.SpinnerGroup122Model
import com.starmakers.app.modules.artistbookongfive.`data`.viewmodel.ArtistBookongFiveVM
import com.starmakers.app.modules.artistbookongtwo.ui.ArtistBookongTwoActivity
import kotlin.String
import kotlin.Unit

class ArtistBookongFiveActivity :
    BaseActivity<ActivityArtistBookongFiveBinding>(R.layout.activity_artist_bookong_five) {
  private val viewModel: ArtistBookongFiveVM by viewModels<ArtistBookongFiveVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    viewModel.spinnerGroup122List.value = mutableListOf(
    SpinnerGroup122Model("Item1"),
    SpinnerGroup122Model("Item2"),
    SpinnerGroup122Model("Item3"),
    SpinnerGroup122Model("Item4"),
    SpinnerGroup122Model("Item5")
    )
    val spinnerGroup122Adapter =
    SpinnerGroup122Adapter(this,R.layout.spinner_item,viewModel.spinnerGroup122List.value?:
    mutableListOf())
    binding.spinnerGroup122.adapter = spinnerGroup122Adapter
    viewModel.spinnerComponentEightList.value = mutableListOf(
    SpinnerComponentEightModel("Item1"),
    SpinnerComponentEightModel("Item2"),
    SpinnerComponentEightModel("Item3"),
    SpinnerComponentEightModel("Item4"),
    SpinnerComponentEightModel("Item5")
    )
    val spinnerComponentEightAdapter =
    SpinnerComponentEightAdapter(this,R.layout.spinner_item,viewModel.spinnerComponentEightList.value?:
    mutableListOf())
    binding.spinnerComponentEight.adapter = spinnerComponentEightAdapter
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
    binding.artistBookongFiveVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnSearch.setOnClickListener {
      val destIntent = ArtistBookongTwoActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
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

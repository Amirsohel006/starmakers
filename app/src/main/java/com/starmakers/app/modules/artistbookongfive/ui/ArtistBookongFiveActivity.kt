package com.starmakers.app.modules.artistbookongfive.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
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
    viewModel.spinnerComponentEightList.value = mutableListOf(
    SpinnerComponentEightModel("Choose Acting Field"),
    SpinnerComponentEightModel("Movies"),
    SpinnerComponentEightModel("Serials"),

    )
    val spinnerComponentEightAdapter =
    SpinnerComponentEightAdapter(this,R.layout.spinner_item,viewModel.spinnerComponentEightList.value?:
    mutableListOf())
    binding.spinnerComponentEight.adapter = spinnerComponentEightAdapter
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
    binding.artistBookongFiveVM = viewModel


    window.statusBarColor= ContextCompat.getColor(this,R.color.statusbar2)
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

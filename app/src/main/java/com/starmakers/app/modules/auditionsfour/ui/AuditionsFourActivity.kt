package com.starmakers.app.modules.auditionsfour.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityAuditionsFourBinding
import com.starmakers.app.modules.artistmembership.data.model.SpinnerComponentOneModel
import com.starmakers.app.modules.auditionsfour.`data`.model.SpinnerComponentNineModel
import com.starmakers.app.modules.auditionsfour.`data`.viewmodel.AuditionsFourVM
import com.starmakers.app.modules.frametwentythree.ui.FrameTwentythreeActivity
import kotlin.String
import kotlin.Unit

class AuditionsFourActivity :
    BaseActivity<ActivityAuditionsFourBinding>(R.layout.activity_auditions_four) {
  private val viewModel: AuditionsFourVM by viewModels<AuditionsFourVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    viewModel.spinnerComponentNineList.value = mutableListOf(
      SpinnerComponentNineModel("Applying for role"),
      SpinnerComponentNineModel("Actor"),
      SpinnerComponentNineModel("Actress"),
      SpinnerComponentNineModel("Director"),
      SpinnerComponentNineModel("Assistant Director"),
      SpinnerComponentNineModel("Associate Director"),
      SpinnerComponentNineModel("Cameraman"),
      SpinnerComponentNineModel("Story Writer"),
      SpinnerComponentNineModel("Dialogue Writer"),
      SpinnerComponentNineModel("Singer"),
      SpinnerComponentNineModel("Supporting Singer"),
      SpinnerComponentNineModel("Fight Master"),
      SpinnerComponentNineModel("Dance Master"),
      SpinnerComponentNineModel("Dancer"),
      SpinnerComponentNineModel("Fighter"),
      SpinnerComponentNineModel("Still Photographer"),
      SpinnerComponentNineModel("Makeup Man"),
      SpinnerComponentNineModel("Hair Stylist"),
      SpinnerComponentNineModel("Costume Designer"),
      SpinnerComponentNineModel("Dubbing Artist"),
      SpinnerComponentNineModel("Artist Personal Assistant"),
      SpinnerComponentNineModel("Artist Personal Body Guard"),
      SpinnerComponentNineModel("Artist Personal Manager"),
      SpinnerComponentNineModel("Production Manager"),
      SpinnerComponentNineModel("Spot Boy"),
      SpinnerComponentNineModel("Set Artist/Worker")
    )
    val spinnerComponentNineAdapter =
    SpinnerComponentNineAdapter(this,R.layout.spinner_item,viewModel.spinnerComponentNineList.value?:
    mutableListOf())
    binding.spinnerComponentNine.adapter = spinnerComponentNineAdapter
    binding.auditionsFourVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnParticipate.setOnClickListener {
      val destIntent = FrameTwentythreeActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "AUDITIONS_FOUR_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, AuditionsFourActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}

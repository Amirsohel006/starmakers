package com.starmakers.app.modules.auditionsfour.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityAuditionsFourBinding
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
    SpinnerComponentNineModel("Item1"),
    SpinnerComponentNineModel("Item2"),
    SpinnerComponentNineModel("Item3"),
    SpinnerComponentNineModel("Item4"),
    SpinnerComponentNineModel("Item5")
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

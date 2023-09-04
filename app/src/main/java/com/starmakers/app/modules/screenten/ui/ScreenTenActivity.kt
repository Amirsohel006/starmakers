package com.starmakers.app.modules.screenten.ui

import android.net.Uri
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityScreenTenBinding
import com.starmakers.app.modules.screenten.`data`.model.ImageSliderSliderintrestonloanModel
import com.starmakers.app.modules.screenten.`data`.viewmodel.ScreenTenVM
import kotlin.String
import kotlin.Unit
import kotlin.collections.ArrayList

class ScreenTenActivity : BaseActivity<ActivityScreenTenBinding>(R.layout.activity_screen_ten) {
  private val imageUri: Uri =
      Uri.parse("android.resource://com.ameersapplication.app/drawable/img_intrestonloan_256x309")


  private val imageSliderSliderintrestonloanItems: ArrayList<ImageSliderSliderintrestonloanModel> =
      arrayListOf(ImageSliderSliderintrestonloanModel(imageIntrestonloan =
  imageUri.toString()),ImageSliderSliderintrestonloanModel(imageIntrestonloan =
  imageUri.toString()))


  private val viewModel: ScreenTenVM by viewModels<ScreenTenVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val sliderintrestonloanAdapter =
    SliderintrestonloanAdapter(imageSliderSliderintrestonloanItems,true)
    binding.imageSliderSliderintrestonloan.adapter = sliderintrestonloanAdapter
    binding.screenTenVM = viewModel

    window.statusBarColor= ContextCompat.getColor(this,R.color.statusbar2)
  }

  override fun onPause(): Unit {
    binding.imageSliderSliderintrestonloan.pauseAutoScroll()
    super.onPause()
  }

  override fun onResume(): Unit {
    super.onResume()
    binding.imageSliderSliderintrestonloan.resumeAutoScroll()
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "SCREEN_TEN_ACTIVITY"

  }
}

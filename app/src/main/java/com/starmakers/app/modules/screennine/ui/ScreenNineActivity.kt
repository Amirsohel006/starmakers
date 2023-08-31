package com.starmakers.app.modules.screennine.ui

import android.net.Uri
import androidx.activity.viewModels
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityScreenNineBinding
import com.starmakers.app.modules.screennine.`data`.model.ImageSliderSliderintrestonloanModel
import com.starmakers.app.modules.screennine.`data`.viewmodel.ScreenNineVM
import kotlin.String
import kotlin.Unit
import kotlin.collections.ArrayList

class ScreenNineActivity : BaseActivity<ActivityScreenNineBinding>(R.layout.activity_screen_nine) {
  private val imageUri: Uri =
      Uri.parse("android.resource://com.ameersapplication.app/drawable/img_intrestonloan_258x315")


  private val imageSliderSliderintrestonloanItems: ArrayList<ImageSliderSliderintrestonloanModel> =
      arrayListOf(ImageSliderSliderintrestonloanModel(imageIntrestonloan =
  imageUri.toString()),ImageSliderSliderintrestonloanModel(imageIntrestonloan =
  imageUri.toString()))


  private val viewModel: ScreenNineVM by viewModels<ScreenNineVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val sliderintrestonloanAdapter =
    SliderintrestonloanAdapter(imageSliderSliderintrestonloanItems,true)
    binding.imageSliderSliderintrestonloan.adapter = sliderintrestonloanAdapter
    binding.screenNineVM = viewModel
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
    const val TAG: String = "SCREEN_NINE_ACTIVITY"

  }
}

package com.starmakers.app.modules.home.ui

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.viewModels
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseFragment
import com.starmakers.app.databinding.FragmentHomeBinding
import com.starmakers.app.modules.home.`data`.model.ImageSliderSliderrectangleelevenModel
import com.starmakers.app.modules.home.`data`.model.SpinnerGroup122Model
import com.starmakers.app.modules.home.`data`.viewmodel.HomeVM
import kotlin.String
import kotlin.Unit
import kotlin.collections.ArrayList

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
  private val imageUri: Uri =
      Uri.parse("android.resource://com.starmakers.app/drawable/img_rectangle11")


  private val imageSliderSliderrectangleelevenItems:
      ArrayList<ImageSliderSliderrectangleelevenModel> =
      arrayListOf(ImageSliderSliderrectangleelevenModel(imageRectangleEleven =
  imageUri.toString()),ImageSliderSliderrectangleelevenModel(imageRectangleEleven =
  imageUri.toString()))


  private val viewModel: HomeVM by viewModels<HomeVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = arguments
    viewModel.spinnerGroup122List.value = mutableListOf(
    SpinnerGroup122Model("Item1"),
    SpinnerGroup122Model("Item2"),
    SpinnerGroup122Model("Item3"),
    SpinnerGroup122Model("Item4"),
    SpinnerGroup122Model("Item5")
    )
    val spinnerGroup122Adapter =
    SpinnerGroup122Adapter(requireActivity(),R.layout.spinner_item,viewModel.spinnerGroup122List.value?:
    mutableListOf())
    binding.spinnerGroup122.adapter = spinnerGroup122Adapter
    val sliderrectangleelevenAdapter =
    SliderrectangleelevenAdapter(imageSliderSliderrectangleelevenItems,true)
    binding.imageSliderSliderrectangleeleven.adapter = sliderrectangleelevenAdapter
    binding.imageSliderSliderrectangleeleven.onIndicatorProgress = { selectingPosition,
      progress ->
      binding.indicatorVolume.onPageScrolled(selectingPosition, progress)
    }
    binding.indicatorVolume.updateIndicatorCounts(binding.imageSliderSliderrectangleeleven.indicatorCount)
    binding.homeVM = viewModel
  }

  override fun onPause(): Unit {
    binding.imageSliderSliderrectangleeleven.pauseAutoScroll()
    super.onPause()
  }

  override fun onResume(): Unit {
    super.onResume()
    binding.imageSliderSliderrectangleeleven.resumeAutoScroll()
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "HOME_FRAGMENT"


    fun getInstance(bundle: Bundle?): HomeFragment {
      val fragment = HomeFragment()
      fragment.arguments = bundle
      return fragment
    }
  }
}

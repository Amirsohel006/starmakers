package com.starmakers.app.modules.home.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.viewModels
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseFragment
import com.starmakers.app.databinding.FragmentHomeBinding
import com.starmakers.app.modules.artistbookongfive.ui.ArtistBookongFiveActivity
import com.starmakers.app.modules.artistmembership.ui.ArtistMembershipActivity
import com.starmakers.app.modules.auditions.ui.AuditionsActivity
import com.starmakers.app.modules.frame311.ui.Frame311Activity
import com.starmakers.app.modules.home.`data`.model.ImageSliderSliderrectangleelevenModel
import com.starmakers.app.modules.home.`data`.model.SpinnerGroup122Model
import com.starmakers.app.modules.home.`data`.viewmodel.HomeVM
import com.starmakers.app.modules.studiobookong1.ui.StudioBookong1Activity
import org.koin.android.ext.android.bind
import kotlin.String
import kotlin.Unit
import kotlin.collections.ArrayList

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
  private val imageUri: Uri =
      Uri.parse("android.resource://com.starmakers.app/drawable/img_rectangle11")
  private val imageUri1: Uri =
    Uri.parse("android.resource://com.starmakers.app/drawable/image2")
  private val imageUri2: Uri =
    Uri.parse("android.resource://com.starmakers.app/drawable/image3")
  private val imageUri3: Uri =
    Uri.parse("android.resource://com.starmakers.app/drawable/image5")



  private val imageSliderSliderrectangleelevenItems:
      ArrayList<ImageSliderSliderrectangleelevenModel> =
      arrayListOf(ImageSliderSliderrectangleelevenModel(imageRectangleEleven =
  imageUri.toString()),ImageSliderSliderrectangleelevenModel(imageRectangleEleven =
  imageUri1.toString()),ImageSliderSliderrectangleelevenModel(imageRectangleEleven =
      imageUri2.toString()),ImageSliderSliderrectangleelevenModel(imageRectangleEleven =
      imageUri3.toString()))


  private val viewModel: HomeVM by viewModels<HomeVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = arguments
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
    binding.imageMenu.setOnClickListener{
      val i =Intent(requireActivity(),Frame311Activity::class.java)
      startActivity(i)
    }


    binding.linearColumnuntitleddesign.setOnClickListener {
      val i=Intent(requireActivity(), ArtistMembershipActivity::class.java)
      startActivity(i)
    }


    binding.linearColumn.setOnClickListener {
      val i =Intent(requireActivity(), ArtistBookongFiveActivity::class.java)
      startActivity(i)
    }

    binding.linearColumnOne.setOnClickListener {
      val i=Intent(requireActivity(), AuditionsActivity::class.java)
      startActivity(i)
    }

    binding.linearColumnTwo.setOnClickListener {
      val i=Intent(requireActivity(), StudioBookong1Activity::class.java)
      startActivity(i)
    }
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

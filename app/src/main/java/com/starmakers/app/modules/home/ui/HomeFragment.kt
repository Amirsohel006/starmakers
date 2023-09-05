package com.starmakers.app.modules.home.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.fragment.app.viewModels
import com.squareup.picasso.Picasso
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseFragment
import com.starmakers.app.databinding.FragmentHomeBinding
import com.starmakers.app.modules.artistbookongfive.ui.ArtistBookongFiveActivity
import com.starmakers.app.modules.artistbookongone.ui.ArtistBookongOneActivity
import com.starmakers.app.modules.artistmembership.ui.ArtistMembershipActivity
import com.starmakers.app.modules.auditions.ui.AuditionsActivity
import com.starmakers.app.modules.frame311.ui.Frame311Activity
import com.starmakers.app.modules.home.`data`.model.ImageSliderSliderrectangleelevenModel
import com.starmakers.app.modules.home.`data`.model.SpinnerGroup122Model
import com.starmakers.app.modules.home.`data`.viewmodel.HomeVM
import com.starmakers.app.modules.studiobookong1.ui.StudioBookong1Activity
import com.starmakers.app.responses.ProfileResponse
import com.starmakers.app.service.ApiManager
import com.starmakers.app.service.CircleTransformation
import com.starmakers.app.service.SessionManager
import org.koin.android.ext.android.bind
import retrofit2.Call
import retrofit2.Response
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


  private lateinit var sessionManager: SessionManager



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
    sessionManager=SessionManager(requireActivity())

    fetchData()



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


    binding.profilePicture.setOnClickListener {
      val i = Intent(requireActivity(),ArtistBookongOneActivity::class.java)
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


  private fun fetchData(){
    val serviceGenerator= ApiManager.apiInterface
    val accessToken=sessionManager.fetchAuthToken()
    val authorization="Token $accessToken"
    val call=serviceGenerator.getProfile(authorization)

    call.enqueue(object : retrofit2.Callback<ProfileResponse>{
      override fun onResponse(
        call: Call<ProfileResponse>,
        response: Response<ProfileResponse>
      ) {
        val customerResponse=response.body()

        if(customerResponse!=null){
          binding.txtRahul.text=customerResponse.name
//          binding.txtMobileNo.text=customerResponse.mobile_number
//          binding.txtEmail.text=customerResponse.email

          val profilePicture: ImageView =binding.profilePicture


          Picasso.get().load(customerResponse.profile).transform(CircleTransformation()).placeholder(R.drawable.img_ellipse32).into(profilePicture)
        }
      }

      override fun onFailure(call: Call<ProfileResponse>, t: Throwable) {
        t.printStackTrace()
        Log.e("error", t.message.toString())
      }
    })
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

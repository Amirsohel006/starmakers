package com.starmakers.app.modules.activities.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseFragment
import com.starmakers.app.databinding.FragmentActivitiesBinding
import com.starmakers.app.modules.activities.`data`.model.ActivitiesRowModel
import com.starmakers.app.modules.activities.`data`.viewmodel.ActivitiesVM
import com.starmakers.app.modules.artistbookongfive.ui.ArtistBookongFiveActivity
import com.starmakers.app.modules.artistbookongone.ui.ArtistBookongOneActivity
import com.starmakers.app.modules.artistmembership.ui.ArtistMembershipActivity
import com.starmakers.app.modules.auditions.ui.AuditionsActivity
import com.starmakers.app.modules.auditionstwo.ui.AuditionsTwoActivity
import com.starmakers.app.modules.campaignone.ui.CampaignOneActivity
import com.starmakers.app.modules.frame311.ui.Frame311Activity
import com.starmakers.app.modules.membershipoptioncomingsoon.ComingSoon
import com.starmakers.app.modules.request.ui.StudioRequestAdapter
import com.starmakers.app.modules.requestone.ui.RequestOneActivity
import com.starmakers.app.modules.studiobookong1.ui.StudioBookong1Activity
import com.starmakers.app.responses.ProfileResponse
import com.starmakers.app.responses.StudioRequests
import com.starmakers.app.service.ApiManager
import com.starmakers.app.service.CircleTransformation
import com.starmakers.app.service.SessionManager
import layout.MyAuditionRequest
import retrofit2.Call
import retrofit2.Response
import kotlin.Int
import kotlin.String
import kotlin.Unit

class ActivitiesFragment : BaseFragment<FragmentActivitiesBinding>(R.layout.fragment_activities) {
  private val viewModel: ActivitiesVM by viewModels<ActivitiesVM>()


  private lateinit var sessionManager: SessionManager
  override fun onInitialized(): Unit {
    sessionManager=SessionManager(requireActivity())

    fetchData()
    getMyAuditionRequests()
    fetchStudioRequest()


    viewModel.navArguments = arguments
    binding.activitiesVM = viewModel
  }

  override fun setUpClicks(): Unit {


    binding.profilePicture.setOnClickListener {
      val i = Intent(requireActivity(), ArtistBookongOneActivity::class.java)
      startActivity(i)
    }


    binding.imageMenu.setOnClickListener {
      val i =Intent(requireActivity(), Frame311Activity::class.java)
      startActivity(i)
    }
//    binding.imageRectangle107.setOnClickListener {
//      val destIntent = CampaignOneActivity.getIntent(requireActivity(), null)
//      startActivity(destIntent)
//      requireActivity().onBackPressed()
//    }
//    binding.imageRectangle106.setOnClickListener {
//      val destIntent = CampaignOneActivity.getIntent(requireActivity(), null)
//      startActivity(destIntent)
//      requireActivity().onBackPressed()
//    }
    binding.linearRowuntitleddesignFour.setOnClickListener {
      val destIntent = RequestOneActivity.getIntent(requireActivity(), null)
      startActivity(destIntent)
      requireActivity().onBackPressed()
    }
//    binding.txtRamanandStudio.setOnClickListener {
//      val destIntent = AuditionsTwoActivity.getIntent(requireActivity(), null)
//      startActivity(destIntent)
//      requireActivity().onBackPressed()
//    }
//    binding.btnViewDetails.setOnClickListener {
//      val destIntent = AuditionsTwoActivity.getIntent(requireActivity(), null)
//      startActivity(destIntent)
//      requireActivity().onBackPressed()
//    }
//    binding.imageRectangleNineteen.setOnClickListener {
//      val destIntent = AuditionsTwoActivity.getIntent(requireActivity(), null)
//      startActivity(destIntent)
//      requireActivity().onBackPressed()
//    }


    binding.linearColumnuntitleddesign5.setOnClickListener{
      val i=Intent(requireActivity(),StudioBookong1Activity::class.java)
      startActivity(i)
    }


//    binding.linearColumnuntitleddesign.setOnClickListener {
//      val i=Intent(requireActivity(),ArtistMembershipActivity::class.java)
//      startActivity(i)
//    }

        binding.linearColumnuntitleddesign.setOnClickListener {
      val i=Intent(requireActivity(),ComingSoon::class.java)
      startActivity(i)
    }


    binding.linearColumnuntitleddesign4.setOnClickListener {
      val i=Intent(requireActivity(),AuditionsActivity::class.java)
      startActivity(i)
    }


    binding.linearColumnuntitleddesign1.setOnClickListener {
      val i =Intent(requireActivity(),ArtistBookongFiveActivity::class.java)
      startActivity(i)
    }
  }

  fun onClickRecyclerActivities(
    view: View,
    position: Int,
    item: ActivitiesRowModel
  ): Unit {
    when(view.id) {
      R.id.linearColumnuntitleddesign -> {
        onClickRecyclerActivitiesLinearColumnuntitleddesign(view, position, item)
      }
    }
  }

  fun onClickRecyclerActivitiesLinearColumnuntitleddesign(
    view: View,
    position: Int,
    item: ActivitiesRowModel
  ): Unit {
    /** TODO As per your logic, Add constant type for item click.*/
    when(0) {
      0 -> {
        val destIntent = AuditionsActivity.getIntent(requireActivity(), null)
        startActivity(destIntent)
        requireActivity().onBackPressed()
      }
      1 -> {
        val destIntent = ArtistMembershipActivity.getIntent(requireActivity(), null)
        startActivity(destIntent)
        requireActivity().onBackPressed()
      }
      2 -> {
        val destIntent = ArtistBookongFiveActivity.getIntent(requireActivity(), null)
        startActivity(destIntent)
        requireActivity().onBackPressed()
      }
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

  fun fetchStudioRequest(){
    val serviceGenerator= ApiManager.apiInterface
    val accessToken=sessionManager.fetchAuthToken()
    val authorization="Token $accessToken"
    val call=serviceGenerator.getStudioRequest(authorization)


    call.enqueue(object : retrofit2.Callback<MutableList<StudioRequests>>{
      override fun onResponse(
        call: Call<MutableList<StudioRequests>>,
        response: Response<MutableList<StudioRequests>>
      ) {
        val customerResponse=response.body()

        if(customerResponse!=null){
          val responsefinal=response.body()

          binding.recyclerforstudios.apply {
            layoutManager=
              LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL,false)
            val studioadapter= responsefinal?.let { StudioRequestAdapter(it) }
            binding.recyclerforstudios.adapter=studioadapter
          }
        }
      }

      override fun onFailure(call: Call<MutableList<StudioRequests>>, t: Throwable) {
        t.printStackTrace()
        Log.e("error", t.message.toString())
      }
    })
  }


  private fun getMyAuditionRequests(){

    val serviceGenerator= ApiManager.apiInterface
    val accessToken=sessionManager.fetchAuthToken()
    val authorization="Token $accessToken"
    val call=serviceGenerator.getMyAuditionRequest(authorization)

    call.enqueue(object : retrofit2.Callback<MutableList<MyAuditionRequest>>{
      override fun onResponse(
        call: Call<MutableList<MyAuditionRequest>>,
        response: Response<MutableList<MyAuditionRequest>>
      ) {
        val customerResponse=response.body()

        if(customerResponse!=null){
          val responsefinal=response.body()



          val recyclerView = binding.myauditions
          recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
          val myauditionadapter = responsefinal?.let { MyAuditionAdapter(it) }
          recyclerView.adapter = myauditionadapter

//          binding.myauditions.apply {
//            layoutManager=
//              LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL,false)
//            val myauditionadapter= responsefinal?.let { MyAuditionAdapter(it) }
//            binding.myauditions.adapter=myauditionadapter
//          }
        }
      }

      override fun onFailure(call: Call<MutableList<MyAuditionRequest>>, t: Throwable) {
        t.printStackTrace()
        Log.e("error", t.message.toString())
      }
    })
  }

  companion object {
    const val TAG: String = "ACTIVITIES_FRAGMENT"


    fun getInstance(bundle: Bundle?): ActivitiesFragment {
      val fragment = ActivitiesFragment()
      fragment.arguments = bundle
      return fragment
    }
  }
}

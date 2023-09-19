package com.starmakers.app.modules.financialoverview.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseFragment
import com.starmakers.app.databinding.FragmentFinancialOverviewBinding
import com.starmakers.app.modules.artistbookongone.ui.ArtistBookongOneActivity
import com.starmakers.app.modules.auditionsone.ui.AuditionsOneActivity
import com.starmakers.app.modules.financialoverview.`data`.model.GridrectangletenRowModel
import com.starmakers.app.modules.financialoverview.`data`.model.SpinnerGroup122Model
import com.starmakers.app.modules.financialoverview.`data`.viewmodel.FinancialOverviewVM
import com.starmakers.app.modules.frame311.ui.Frame311Activity
import com.starmakers.app.modules.request.ui.StudioRequestAdapter
import com.starmakers.app.responses.CampaignResponse
import com.starmakers.app.responses.MyStudioRequest
import com.starmakers.app.responses.ProfileResponse
import com.starmakers.app.service.ApiManager
import com.starmakers.app.service.CircleTransformation
import com.starmakers.app.service.SessionManager
import retrofit2.Call
import retrofit2.Response
import kotlin.Int
import kotlin.String
import kotlin.Unit

class FinancialOverviewFragment :
    BaseFragment<FragmentFinancialOverviewBinding>(R.layout.fragment_financial_overview) {
  private val viewModel: FinancialOverviewVM by viewModels<FinancialOverviewVM>()

  private lateinit var sessionManager: SessionManager
  override fun onInitialized(): Unit {
    viewModel.navArguments = arguments

    sessionManager=SessionManager(requireActivity())
    fetchData()

    getCampaign()
//    val gridrectangletenAdapter =
//    GridrectangletenAdapter(viewModel.gridrectangletenList.value?:mutableListOf())
//    binding.recyclerGridrectangleten.adapter = gridrectangletenAdapter
//    gridrectangletenAdapter.setOnItemClickListener(
//    object : GridrectangletenAdapter.OnItemClickListener {
//      override fun onItemClick(view:View, position:Int, item : GridrectangletenRowModel) {
//        onClickRecyclerGridrectangleten(view, position, item)
//      }
//    }
//    )
//    viewModel.gridrectangletenList.observe(requireActivity()) {
//      gridrectangletenAdapter.updateData(it)
//    }
    binding.financialOverviewVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageMenu.setOnClickListener {
      val i =Intent(requireActivity(),Frame311Activity::class.java)
      startActivity(i)
    }

    binding.profilePicture.setOnClickListener {
      val i = Intent(requireActivity(), ArtistBookongOneActivity::class.java)
      startActivity(i)
    }
  }

  fun onClickRecyclerGridrectangleten(
    view: View,
    position: Int,
    item: GridrectangletenRowModel
  ): Unit {
    when(view.id) {
      R.id.linearRowviewdetails -> {
        val destIntent = AuditionsOneActivity.getIntent(requireActivity(), null)
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



  fun getCampaign(){
    val serviceGenerator= ApiManager.apiInterface
    val accessToken=sessionManager.fetchAuthToken()
    val authorization="Token $accessToken"
    val call=serviceGenerator.getcampaign(authorization)

    call.enqueue(object : retrofit2.Callback<CampaignResponse>{
      override fun onResponse(
        call: Call<CampaignResponse>,
        response: Response<CampaignResponse>
      ) {
        val customerResponse=response.body()

        if(customerResponse!=null){

          binding.recyclerGridrectangleten.apply {
            val studioadapter= GridrectangletenAdapter(customerResponse.data)
            binding.recyclerGridrectangleten.adapter=studioadapter
          }
        }
      }

      override fun onFailure(call: Call<CampaignResponse>, t: Throwable) {
        t.printStackTrace()
        Log.e("error", t.message.toString())
      }
    })
  }
  companion object {
    const val TAG: String = "FINANCIAL_OVERVIEW_FRAGMENT"


    fun getInstance(bundle: Bundle?): FinancialOverviewFragment {
      val fragment = FinancialOverviewFragment()
      fragment.arguments = bundle
      return fragment
    }
  }
}

package com.starmakers.app.modules.studiobookong.ui

import android.util.Log
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseFragment
import com.starmakers.app.databinding.FragmentStudioBookongBinding
import com.starmakers.app.modules.auditions.ui.AuditionsAdapter
import com.starmakers.app.modules.auditionstwo.ui.AuditionsTwoActivity
import com.starmakers.app.modules.frame316.ui.Frame316Activity
import com.starmakers.app.modules.studiobookong.`data`.model.StudioBookongRowModel
import com.starmakers.app.modules.studiobookong.`data`.viewmodel.StudioBookongVM
import com.starmakers.app.modules.studiobookong1.ui.StudioBookong1Activity
import com.starmakers.app.responses.EditingStudio
import com.starmakers.app.responses.EditingStudioData
import com.starmakers.app.responses.StudioRequest
import com.starmakers.app.service.ApiManager
import com.starmakers.app.service.SessionManager
import retrofit2.Call
import retrofit2.Response
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit

class StudioBookongFragment :
    BaseFragment<FragmentStudioBookongBinding>(R.layout.fragment_studio_bookong) {
  private val viewModel: StudioBookongVM by viewModels<StudioBookongVM>()

  private lateinit var sessionManager: SessionManager

  private lateinit var studioBookongAdapter: StudioBookongAdapter
  private var fullStudioList: List<EditingStudio> = listOf()
  override fun onInitialized(): Unit {
    viewModel.navArguments = arguments
    sessionManager = SessionManager(requireActivity())
//    val studioBookongAdapter =
//    StudioBookongAdapter(viewModel.studioBookongList.value?:mutableListOf())
//    binding.recyclerStudioBookong.adapter = studioBookongAdapter
//    studioBookongAdapter.setOnItemClickListener(
//    object : StudioBookongAdapter.OnItemClickListener {
//      override fun onItemClick(view:View, position:Int, item : StudioBookongRowModel) {
//        onClickRecyclerStudioBookong(view, position, item)
//      }
//    }
//    )
//    viewModel.studioBookongList.observe(requireActivity()) {
//      studioBookongAdapter.updateData(it)
//    }


    fetchStudio("Editing/Dubbing")
    binding.studioBookongVM = viewModel
    setUpSearchViewGroup547Listener()
  }

  override fun setUpClicks(): Unit {
  }

  fun onClickRecyclerStudioBookong(
    view: View,
    position: Int,
    item: StudioBookongRowModel
  ): Unit {
    when(view.id) {
      R.id.txtRamanandStudio ->  {
        val destIntent = AuditionsTwoActivity.getIntent(requireActivity(), null)
        startActivity(destIntent)
        requireActivity().onBackPressed()
      }
      R.id.imageRectangleNineteen ->  {
        val destIntent = AuditionsTwoActivity.getIntent(requireActivity(), null)
        startActivity(destIntent)
        requireActivity().onBackPressed()
      }
      R.id.btnRequest ->  {
        val destIntent = Frame316Activity.getIntent(requireActivity(), null)
        startActivity(destIntent)
        requireActivity().onBackPressed()
      }
    }
  }


  private fun fetchStudio(studioName: String) {
    val serviceGenerator = ApiManager.apiInterface
    val accessToken = sessionManager.fetchAuthToken()
    val authorization = "Token $accessToken"
    val call = serviceGenerator.getStudioRequest(authorization, studioName)

    call.enqueue(object : retrofit2.Callback<EditingStudioData> {
      override fun onResponse(call: Call<EditingStudioData>, response: Response<EditingStudioData>) {
        if (response.isSuccessful) {
          val customerResponse=response.body()

          if((customerResponse!=null)   && (customerResponse.message=="Success")) {
            val editingData=response.body()
            if (editingData != null) {
              fullStudioList = editingData.data
              studioBookongAdapter = StudioBookongAdapter(fullStudioList)
              binding.recyclerStudioBookong.apply {
                layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
                adapter = studioBookongAdapter
              }
            }

          }

        } else {
          // Handle the error or non-successful response
          Log.e(StudioBookong1Activity.TAG, "Failed to fetch studio data")
        }
      }

      override fun onFailure(call: Call<EditingStudioData>, t: Throwable) {
        t.printStackTrace()
        Log.e(StudioBookong1Activity.TAG, "Error: ${t.message}")
      }
    })
  }

  private fun setUpSearchViewGroup547Listener(): Unit {
    binding.searchViewGroup547.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
      override fun onQueryTextSubmit(query : String) : Boolean {
        filterStudioList(query)
        return false
      }
      override fun onQueryTextChange(newText : String) : Boolean {
        filterStudioList(newText)
        return false
      }
      })
    }


  private fun filterStudioList(query: String) {
    val filteredList = fullStudioList.filter {
      it.studio_name.contains(query, ignoreCase = true)
    }
    studioBookongAdapter.updateData(filteredList)
  }
    companion object {
      const val TAG: String = "STUDIO_BOOKONG_FRAGMENT"

    }
  }

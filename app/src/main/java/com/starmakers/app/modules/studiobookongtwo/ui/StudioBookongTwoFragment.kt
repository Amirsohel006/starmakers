package com.starmakers.app.modules.studiobookongtwo.ui

import android.util.Log
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseFragment
import com.starmakers.app.databinding.FragmentStudioBookongTwoBinding
import com.starmakers.app.modules.auditionstwo.ui.AuditionsTwoActivity
import com.starmakers.app.modules.frame316.ui.Frame316Activity
import com.starmakers.app.modules.studiobookong1.ui.StudioBookong1Activity
import com.starmakers.app.modules.studiobookongone.ui.ListrectanglenineteenAdapter
import com.starmakers.app.modules.studiobookongtwo.`data`.model.Listrectanglenineteen1RowModel
import com.starmakers.app.modules.studiobookongtwo.`data`.viewmodel.StudioBookongTwoVM
import com.starmakers.app.responses.HouseLocationDataResponse
import com.starmakers.app.responses.HouseLocationStudio
import com.starmakers.app.responses.MusicStudioDataResponse
import com.starmakers.app.responses.Studio
import com.starmakers.app.service.ApiManager
import com.starmakers.app.service.SessionManager
import retrofit2.Call
import retrofit2.Response
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit

class StudioBookongTwoFragment :
    BaseFragment<FragmentStudioBookongTwoBinding>(R.layout.fragment_studio_bookong_two) {
  private val viewModel: StudioBookongTwoVM by viewModels<StudioBookongTwoVM>()

  private lateinit var sessionManager: SessionManager

  private lateinit var studioBookongAdapter: ListrectanglenineteenAdapterHouse
  private var fullStudioList: List<HouseLocationStudio> = listOf()

  override fun onInitialized(): Unit {
    viewModel.navArguments = arguments
    sessionManager = SessionManager(requireActivity())

    fetchStudio("House Location")
//    val listrectanglenineteenAdapter =
//    ListrectanglenineteenAdapter(viewModel.listrectanglenineteenList.value?:mutableListOf())
//    binding.recyclerListrectanglenineteen.adapter = listrectanglenineteenAdapter
//    listrectanglenineteenAdapter.setOnItemClickListener(
//    object : ListrectanglenineteenAdapter.OnItemClickListener {
//      override fun onItemClick(view:View, position:Int, item :
//      Listrectanglenineteen1RowModel) {
//        onClickRecyclerListrectanglenineteen(view, position, item)
//      }
//    }
//    )
//    viewModel.listrectanglenineteenList.observe(requireActivity()) {
//      listrectanglenineteenAdapter.updateData(it)
//    }
    binding.studioBookongTwoVM = viewModel
    setUpSearchViewGroup547Listener()
  }

  override fun setUpClicks(): Unit {
  }

  fun onClickRecyclerListrectanglenineteen(
    view: View,
    position: Int,
    item: Listrectanglenineteen1RowModel
  ): Unit {
    when(view.id) {
      R.id.btnRequest ->  {
        val destIntent = Frame316Activity.getIntent(requireActivity(), null)
        startActivity(destIntent)
        requireActivity().onBackPressed()
      }
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
    }
  }


  private fun fetchStudio(studioName: String) {
    val serviceGenerator = ApiManager.apiInterface
    val accessToken = sessionManager.fetchAuthToken()
    val authorization = "Token $accessToken"
    val call = serviceGenerator.getHouseStudioRequest(authorization, studioName)

    call.enqueue(object : retrofit2.Callback<HouseLocationDataResponse> {
      override fun onResponse(call: Call<HouseLocationDataResponse>, response: Response<HouseLocationDataResponse>) {
        if (response.isSuccessful) {
          val customerResponse=response.body()

          if((customerResponse!=null)   && (customerResponse.message=="Success")) {
            val editingData=response.body()
//            binding.recyclerListrectanglenineteen.apply {
//              layoutManager=
//                LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL,false)
//              val audtioAdapter= ListrectanglenineteenAdapterHouse(editingData!!.data)
//              binding.recyclerListrectanglenineteen.adapter=audtioAdapter
//            }

            if (editingData != null) {
              fullStudioList = editingData.data
              studioBookongAdapter = ListrectanglenineteenAdapterHouse(editingData!!.data)
              binding.recyclerListrectanglenineteen.apply {
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

      override fun onFailure(call: Call<HouseLocationDataResponse>, t: Throwable) {
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
      const val TAG: String = "STUDIO_BOOKONG_TWO_FRAGMENT"

    }
  }

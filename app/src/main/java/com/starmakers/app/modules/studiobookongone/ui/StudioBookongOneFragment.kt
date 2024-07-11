package com.starmakers.app.modules.studiobookongone.ui

import android.util.Log
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseFragment
import com.starmakers.app.databinding.FragmentStudioBookongOneBinding
import com.starmakers.app.modules.auditionstwo.ui.AuditionsTwoActivity
import com.starmakers.app.modules.frame316.ui.Frame316Activity
import com.starmakers.app.modules.studiobookong.ui.StudioBookongAdapter
import com.starmakers.app.modules.studiobookong1.ui.StudioBookong1Activity
import com.starmakers.app.modules.studiobookongone.`data`.model.ListrectanglenineteenRowModel
import com.starmakers.app.modules.studiobookongone.`data`.viewmodel.StudioBookongOneVM
import com.starmakers.app.responses.EditingStudio
import com.starmakers.app.responses.EditingStudioData
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

class StudioBookongOneFragment :
    BaseFragment<FragmentStudioBookongOneBinding>(R.layout.fragment_studio_bookong_one) {
  private val viewModel: StudioBookongOneVM by viewModels<StudioBookongOneVM>()

  private lateinit var sessionManager: SessionManager

  private lateinit var studioBookongAdapter: ListrectanglenineteenAdapter
  private var fullStudioList: List<Studio> = listOf()
  override fun onInitialized(): Unit {
    viewModel.navArguments = arguments
    sessionManager = SessionManager(requireActivity())


    fetchStudio("Music Recording")
//    val listrectanglenineteenAdapter =
//    ListrectanglenineteenAdapter(viewModel.listrectanglenineteenList.value?:mutableListOf())
//    binding.recyclerListrectanglenineteen.adapter = listrectanglenineteenAdapter
//    listrectanglenineteenAdapter.setOnItemClickListener(
//    object : ListrectanglenineteenAdapter.OnItemClickListener {
//      override fun onItemClick(view:View, position:Int, item :
//      ListrectanglenineteenRowModel) {
//        onClickRecyclerListrectanglenineteen(view, position, item)
//      }
//    }
//    )
//    viewModel.listrectanglenineteenList.observe(requireActivity()) {
//      listrectanglenineteenAdapter.updateData(it)
//    }
    binding.studioBookongOneVM = viewModel
    setUpSearchViewGroup547Listener()
  }

  override fun setUpClicks(): Unit {
  }

  fun onClickRecyclerListrectanglenineteen(
    view: View,
    position: Int,
    item: ListrectanglenineteenRowModel
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
    val call = serviceGenerator.getMusicStudioRequest(authorization, studioName)

    call.enqueue(object : retrofit2.Callback<MusicStudioDataResponse> {
      override fun onResponse(call: Call<MusicStudioDataResponse>, response: Response<MusicStudioDataResponse>) {
        if (response.isSuccessful) {
          val customerResponse=response.body()

          if((customerResponse!=null)   && (customerResponse.message=="Success")) {
            val editingData=response.body()
//            binding.recyclerListrectanglenineteen.apply {
//              layoutManager=
//                LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL,false)
//              val audtioAdapter= ListrectanglenineteenAdapter(editingData!!.data)
//              binding.recyclerListrectanglenineteen.adapter=audtioAdapter
//            }


            if (editingData != null) {
              fullStudioList = editingData.data
              studioBookongAdapter = ListrectanglenineteenAdapter(editingData!!.data)
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

      override fun onFailure(call: Call<MusicStudioDataResponse>, t: Throwable) {
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
      const val TAG: String = "STUDIO_BOOKONG_ONE_FRAGMENT"

    }
  }

package com.starmakers.app.modules.studiobookong.ui

import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseFragment
import com.starmakers.app.databinding.FragmentStudioBookongBinding
import com.starmakers.app.modules.auditionstwo.ui.AuditionsTwoActivity
import com.starmakers.app.modules.frame316.ui.Frame316Activity
import com.starmakers.app.modules.studiobookong.`data`.model.StudioBookongRowModel
import com.starmakers.app.modules.studiobookong.`data`.viewmodel.StudioBookongVM
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit

class StudioBookongFragment :
    BaseFragment<FragmentStudioBookongBinding>(R.layout.fragment_studio_bookong) {
  private val viewModel: StudioBookongVM by viewModels<StudioBookongVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = arguments
    val studioBookongAdapter =
    StudioBookongAdapter(viewModel.studioBookongList.value?:mutableListOf())
    binding.recyclerStudioBookong.adapter = studioBookongAdapter
    studioBookongAdapter.setOnItemClickListener(
    object : StudioBookongAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : StudioBookongRowModel) {
        onClickRecyclerStudioBookong(view, position, item)
      }
    }
    )
    viewModel.studioBookongList.observe(requireActivity()) {
      studioBookongAdapter.updateData(it)
    }
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

  private fun setUpSearchViewGroup547Listener(): Unit {
    binding.searchViewGroup547.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
      override fun onQueryTextSubmit(p0 : String) : Boolean {
        // Performs search when user hit
        // the search button on the keyboard
        return false
      }
      override fun onQueryTextChange(p0 : String) : Boolean {
        // Start filtering the list as user
        // start entering the characters
        return false
      }
      })
    }

    companion object {
      const val TAG: String = "STUDIO_BOOKONG_FRAGMENT"

    }
  }

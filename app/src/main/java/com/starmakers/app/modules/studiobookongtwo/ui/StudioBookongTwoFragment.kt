package com.starmakers.app.modules.studiobookongtwo.ui

import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseFragment
import com.starmakers.app.databinding.FragmentStudioBookongTwoBinding
import com.starmakers.app.modules.auditionstwo.ui.AuditionsTwoActivity
import com.starmakers.app.modules.frame316.ui.Frame316Activity
import com.starmakers.app.modules.studiobookongtwo.`data`.model.Listrectanglenineteen1RowModel
import com.starmakers.app.modules.studiobookongtwo.`data`.viewmodel.StudioBookongTwoVM
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit

class StudioBookongTwoFragment :
    BaseFragment<FragmentStudioBookongTwoBinding>(R.layout.fragment_studio_bookong_two) {
  private val viewModel: StudioBookongTwoVM by viewModels<StudioBookongTwoVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = arguments
    val listrectanglenineteenAdapter =
    ListrectanglenineteenAdapter(viewModel.listrectanglenineteenList.value?:mutableListOf())
    binding.recyclerListrectanglenineteen.adapter = listrectanglenineteenAdapter
    listrectanglenineteenAdapter.setOnItemClickListener(
    object : ListrectanglenineteenAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item :
      Listrectanglenineteen1RowModel) {
        onClickRecyclerListrectanglenineteen(view, position, item)
      }
    }
    )
    viewModel.listrectanglenineteenList.observe(requireActivity()) {
      listrectanglenineteenAdapter.updateData(it)
    }
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
      const val TAG: String = "STUDIO_BOOKONG_TWO_FRAGMENT"

    }
  }

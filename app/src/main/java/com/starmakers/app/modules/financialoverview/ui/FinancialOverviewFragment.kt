package com.starmakers.app.modules.financialoverview.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseFragment
import com.starmakers.app.databinding.FragmentFinancialOverviewBinding
import com.starmakers.app.modules.auditionsone.ui.AuditionsOneActivity
import com.starmakers.app.modules.financialoverview.`data`.model.GridrectangletenRowModel
import com.starmakers.app.modules.financialoverview.`data`.model.SpinnerGroup122Model
import com.starmakers.app.modules.financialoverview.`data`.viewmodel.FinancialOverviewVM
import kotlin.Int
import kotlin.String
import kotlin.Unit

class FinancialOverviewFragment :
    BaseFragment<FragmentFinancialOverviewBinding>(R.layout.fragment_financial_overview) {
  private val viewModel: FinancialOverviewVM by viewModels<FinancialOverviewVM>()

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
    val gridrectangletenAdapter =
    GridrectangletenAdapter(viewModel.gridrectangletenList.value?:mutableListOf())
    binding.recyclerGridrectangleten.adapter = gridrectangletenAdapter
    gridrectangletenAdapter.setOnItemClickListener(
    object : GridrectangletenAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : GridrectangletenRowModel) {
        onClickRecyclerGridrectangleten(view, position, item)
      }
    }
    )
    viewModel.gridrectangletenList.observe(requireActivity()) {
      gridrectangletenAdapter.updateData(it)
    }
    binding.financialOverviewVM = viewModel
  }

  override fun setUpClicks(): Unit {
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

  companion object {
    const val TAG: String = "FINANCIAL_OVERVIEW_FRAGMENT"


    fun getInstance(bundle: Bundle?): FinancialOverviewFragment {
      val fragment = FinancialOverviewFragment()
      fragment.arguments = bundle
      return fragment
    }
  }
}

package com.starmakers.app.modules.search.ui

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseFragment
import com.starmakers.app.databinding.FragmentSearchBinding
import com.starmakers.app.modules.search.`data`.viewmodel.SearchVM
import kotlin.String
import kotlin.Unit

class SearchFragment : BaseFragment<FragmentSearchBinding>(R.layout.fragment_search) {
  private val viewModel: SearchVM by viewModels<SearchVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = arguments
    binding.searchVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "SEARCH_FRAGMENT"


    fun getInstance(bundle: Bundle?): SearchFragment {
      val fragment = SearchFragment()
      fragment.arguments = bundle
      return fragment
    }
  }
}

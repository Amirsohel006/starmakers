package com.starmakers.app.modules.search.ui

import android.app.appsearch.SearchResult
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseFragment
import com.starmakers.app.databinding.FragmentSearchBinding
import com.starmakers.app.modules.financialoverview.ui.GridrectangletenAdapter
import com.starmakers.app.modules.search.`data`.viewmodel.SearchVM
import com.starmakers.app.responses.CampaignResponse
import com.starmakers.app.responses.SearchResponses
import com.starmakers.app.service.ApiManager
import com.starmakers.app.service.SessionManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.String
import kotlin.Unit

class SearchFragment : BaseFragment<FragmentSearchBinding>(R.layout.fragment_search) {
  private val viewModel: SearchVM by viewModels<SearchVM>()

  private lateinit var sessionManager:SessionManager
  override fun onInitialized(): Unit {
    viewModel.navArguments = arguments
    sessionManager=SessionManager(requireActivity())



    setupRecyclerView()
    // Set up a text change listener on the EditText
    binding.btnSearchHere.addTextChangedListener(object : TextWatcher {
      override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        // Not needed
      }

      override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        // Not needed
      }

      override fun afterTextChanged(s: Editable?) {
        // Perform search when text changes
        performSearch(s.toString().trim())
      }
    })

    binding.searchVM = viewModel
  }



  private fun setupRecyclerView() {
    val adapter = SearchAdapter(emptyList()) { item ->
      // Handle item click, navigate to detail activity
      // You can pass necessary data using Intent extras
    }
    binding.recyclerforSearch.adapter = adapter
    binding.recyclerforSearch.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
  }


  private fun updateSearchResults(items: List<Any>) {
    val adapter = binding.recyclerforSearch.adapter as SearchAdapter
    adapter.apply {
      this.items = items
      notifyDataSetChanged()
    }
  }









  private fun performSearch(query: String) {
    if (query.isNotEmpty()) {

      val apiService= ApiManager.apiInterface
      apiService.search(query).enqueue(object : Callback<SearchResponses> {
        override fun onResponse(call: Call<SearchResponses>, response: Response<SearchResponses>) {
          if (response.isSuccessful) {
            val searchResponses = response.body()
            val items = mutableListOf<Any>()
            searchResponses.let {
              items.addAll(searchResponses?.artists ?: emptyList())
              items.addAll(searchResponses?.campaigns ?: emptyList())
            }

            updateSearchResults(items)
          } else {
            Log.e(TAG, "Unsuccessful response: ${response.code()}")
            // Handle unsuccessful response
          }
        }

        override fun onFailure(call: Call<SearchResponses>, t: Throwable) {
          // Handle network errors
        }
      })
    }
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

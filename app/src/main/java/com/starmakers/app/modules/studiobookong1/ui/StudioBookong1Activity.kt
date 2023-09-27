package com.starmakers.app.modules.studiobookong1.ui

import android.util.Log
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.google.android.material.tabs.TabLayout
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityStudioBookong1Binding
import com.starmakers.app.modules.studiobookong1.data.viewmodel.StudioBookong1VM
import com.google.android.material.tabs.TabLayoutMediator
import com.starmakers.app.responses.StudioRequest
import com.starmakers.app.service.ApiManager
import com.starmakers.app.service.SessionManager
import retrofit2.Call
import retrofit2.Response

class StudioBookong1Activity :
  BaseActivity<ActivityStudioBookong1Binding>(R.layout.activity_studio_bookong1) {

  private val viewModel: StudioBookong1VM by viewModels<StudioBookong1VM>()
  private lateinit var sessionManager: SessionManager

  override fun onInitialized() {
    sessionManager = SessionManager(this)
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.studioBookong1VM = viewModel
    val adapter = StudioBookong1ActivityPagerAdapter(supportFragmentManager, lifecycle)
    binding.viewPagerViewpager.adapter = adapter

    // Initialize the TabLayoutMediator without attaching it immediately
    val tabLayoutMediator = TabLayoutMediator(binding.tabLayoutGroup2, binding.viewPagerViewpager) { tab, position ->
      val tabText = StudioBookong1ActivityPagerAdapter.title[position]
      tab.text = tabText
//
//      val customTabDrawable = ContextCompat.getDrawable(this, R.drawable.selector_bg_white_a700_radius_10)
//      tab.view.background = customTabDrawable
    }

    // Attach the TabLayoutMediator after setting up the tabs
    tabLayoutMediator.attach()

    // Set up the OnTabSelectedListener for each tab individually
    for (position in 0 until adapter.itemCount) {
      val tab = binding.tabLayoutGroup2.getTabAt(position)
      tab?.let {

        val tabPaddingStart = resources.getDimensionPixelSize(R.dimen.custom_tab_padding_start)
        val tabPaddingEnd = resources.getDimensionPixelSize(R.dimen.custom_tab_padding_end)
        val tabPaddingTop = 0 // Adjust the top padding as needed
        val tabPaddingBottom = 0 // Adjust the bottom padding as needed

        // Set padding for the tab's view
        val tabView = it.view
        tabView.setPadding(tabPaddingStart, tabPaddingTop, tabPaddingEnd, tabPaddingBottom)

        it.view.setOnClickListener {
          // Fetch data for the selected tab
        //  fetchStudio(StudioBookong1ActivityPagerAdapter.title[position])
        }
      }
    }

    window.statusBarColor = ContextCompat.getColor(this, R.color.statusbar2)
  }

  override fun setUpClicks() {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }



  companion object {
    const val TAG: String = "STUDIO_BOOKONG1ACTIVITY"
  }
}

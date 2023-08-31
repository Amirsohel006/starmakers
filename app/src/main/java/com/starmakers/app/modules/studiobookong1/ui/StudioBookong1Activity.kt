package com.starmakers.app.modules.studiobookong1.ui

import androidx.activity.viewModels
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityStudioBookong1Binding
import com.starmakers.app.modules.studiobookong1.`data`.viewmodel.StudioBookong1VM
import com.google.android.material.tabs.TabLayoutMediator
import kotlin.String
import kotlin.Unit

class StudioBookong1Activity :
    BaseActivity<ActivityStudioBookong1Binding>(R.layout.activity_studio_bookong1) {
  private val viewModel: StudioBookong1VM by viewModels<StudioBookong1VM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.studioBookong1VM = viewModel
    val adapter = StudioBookong1ActivityPagerAdapter(supportFragmentManager,lifecycle)
    binding.viewPagerViewpager.adapter = adapter
    TabLayoutMediator(binding.tabLayoutGroup2,binding.viewPagerViewpager) { tab, position ->
      tab.text = StudioBookong1ActivityPagerAdapter.title[position]
      }.attach()
    }

    override fun setUpClicks(): Unit {
      binding.imageArrowleft.setOnClickListener {
        finish()
      }
    }

    companion object {
      const val TAG: String = "STUDIO_BOOKONG1ACTIVITY"

    }
  }

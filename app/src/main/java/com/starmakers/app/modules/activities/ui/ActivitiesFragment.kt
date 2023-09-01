package com.starmakers.app.modules.activities.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseFragment
import com.starmakers.app.databinding.FragmentActivitiesBinding
import com.starmakers.app.modules.activities.`data`.model.ActivitiesRowModel
import com.starmakers.app.modules.activities.`data`.viewmodel.ActivitiesVM
import com.starmakers.app.modules.artistbookongfive.ui.ArtistBookongFiveActivity
import com.starmakers.app.modules.artistmembership.ui.ArtistMembershipActivity
import com.starmakers.app.modules.auditions.ui.AuditionsActivity
import com.starmakers.app.modules.auditionstwo.ui.AuditionsTwoActivity
import com.starmakers.app.modules.campaignone.ui.CampaignOneActivity
import com.starmakers.app.modules.requestone.ui.RequestOneActivity
import com.starmakers.app.modules.studiobookong1.ui.StudioBookong1Activity
import kotlin.Int
import kotlin.String
import kotlin.Unit

class ActivitiesFragment : BaseFragment<FragmentActivitiesBinding>(R.layout.fragment_activities) {
  private val viewModel: ActivitiesVM by viewModels<ActivitiesVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = arguments
    binding.activitiesVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageRectangle107.setOnClickListener {
      val destIntent = CampaignOneActivity.getIntent(requireActivity(), null)
      startActivity(destIntent)
      requireActivity().onBackPressed()
    }
    binding.imageRectangle106.setOnClickListener {
      val destIntent = CampaignOneActivity.getIntent(requireActivity(), null)
      startActivity(destIntent)
      requireActivity().onBackPressed()
    }
    binding.linearRowuntitleddesignFour.setOnClickListener {
      val destIntent = RequestOneActivity.getIntent(requireActivity(), null)
      startActivity(destIntent)
      requireActivity().onBackPressed()
    }
    binding.txtRamanandStudio.setOnClickListener {
      val destIntent = AuditionsTwoActivity.getIntent(requireActivity(), null)
      startActivity(destIntent)
      requireActivity().onBackPressed()
    }
    binding.btnViewDetails.setOnClickListener {
      val destIntent = AuditionsTwoActivity.getIntent(requireActivity(), null)
      startActivity(destIntent)
      requireActivity().onBackPressed()
    }
    binding.imageRectangleNineteen.setOnClickListener {
      val destIntent = AuditionsTwoActivity.getIntent(requireActivity(), null)
      startActivity(destIntent)
      requireActivity().onBackPressed()
    }


    binding.linearColumnuntitleddesign5.setOnClickListener{
      val i=Intent(requireActivity(),StudioBookong1Activity::class.java)
      startActivity(i)
    }


    binding.linearColumnuntitleddesign.setOnClickListener {
      val i=Intent(requireActivity(),ArtistMembershipActivity::class.java)
      startActivity(i)
    }


    binding.linearColumnuntitleddesign4.setOnClickListener {
      val i=Intent(requireActivity(),AuditionsActivity::class.java)
      startActivity(i)
    }


    binding.linearColumnuntitleddesign1.setOnClickListener {
      val i =Intent(requireActivity(),ArtistBookongFiveActivity::class.java)
      startActivity(i)
    }
  }

  fun onClickRecyclerActivities(
    view: View,
    position: Int,
    item: ActivitiesRowModel
  ): Unit {
    when(view.id) {
      R.id.linearColumnuntitleddesign -> {
        onClickRecyclerActivitiesLinearColumnuntitleddesign(view, position, item)
      }
    }
  }

  fun onClickRecyclerActivitiesLinearColumnuntitleddesign(
    view: View,
    position: Int,
    item: ActivitiesRowModel
  ): Unit {
    /** TODO As per your logic, Add constant type for item click.*/
    when(0) {
      0 -> {
        val destIntent = AuditionsActivity.getIntent(requireActivity(), null)
        startActivity(destIntent)
        requireActivity().onBackPressed()
      }
      1 -> {
        val destIntent = ArtistMembershipActivity.getIntent(requireActivity(), null)
        startActivity(destIntent)
        requireActivity().onBackPressed()
      }
      2 -> {
        val destIntent = ArtistBookongFiveActivity.getIntent(requireActivity(), null)
        startActivity(destIntent)
        requireActivity().onBackPressed()
      }
    }
  }

  companion object {
    const val TAG: String = "ACTIVITIES_FRAGMENT"


    fun getInstance(bundle: Bundle?): ActivitiesFragment {
      val fragment = ActivitiesFragment()
      fragment.arguments = bundle
      return fragment
    }
  }
}

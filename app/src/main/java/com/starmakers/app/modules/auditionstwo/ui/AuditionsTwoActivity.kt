package com.starmakers.app.modules.auditionstwo.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityAuditionsTwoBinding
import com.starmakers.app.modules.auditionstwo.`data`.model.AuditionsTwoRowModel
import com.starmakers.app.modules.auditionstwo.`data`.viewmodel.AuditionsTwoVM
import com.starmakers.app.modules.frame316.ui.Frame316Activity
import kotlin.Int
import kotlin.String
import kotlin.Unit

class AuditionsTwoActivity :
    BaseActivity<ActivityAuditionsTwoBinding>(R.layout.activity_auditions_two) {
  private val viewModel: AuditionsTwoVM by viewModels<AuditionsTwoVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val auditionsTwoAdapter =
    AuditionsTwoAdapter(viewModel.auditionsTwoList.value?:mutableListOf())
    binding.recyclerAuditionsTwo.adapter = auditionsTwoAdapter
    auditionsTwoAdapter.setOnItemClickListener(
    object : AuditionsTwoAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : AuditionsTwoRowModel) {
        onClickRecyclerAuditionsTwo(view, position, item)
      }
    }
    )
    viewModel.auditionsTwoList.observe(this) {
      auditionsTwoAdapter.updateData(it)
    }
    binding.auditionsTwoVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
    binding.btnRequestStudio.setOnClickListener {
      val destIntent = Frame316Activity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  fun onClickRecyclerAuditionsTwo(
    view: View,
    position: Int,
    item: AuditionsTwoRowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "AUDITIONS_TWO_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, AuditionsTwoActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}

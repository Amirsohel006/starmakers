package com.starmakers.app.modules.auditionsthree.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityAuditionsThreeBinding
import com.starmakers.app.modules.auditionsthree.`data`.model.Listrectangle146RowModel
import com.starmakers.app.modules.auditionsthree.`data`.viewmodel.AuditionsThreeVM
import kotlin.Int
import kotlin.String
import kotlin.Unit

class AuditionsThreeActivity :
    BaseActivity<ActivityAuditionsThreeBinding>(R.layout.activity_auditions_three) {
  private val viewModel: AuditionsThreeVM by viewModels<AuditionsThreeVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val listrectangle146Adapter =
    Listrectangle146Adapter(viewModel.listrectangle146List.value?:mutableListOf())
    binding.recyclerListrectangle146.adapter = listrectangle146Adapter
    listrectangle146Adapter.setOnItemClickListener(
    object : Listrectangle146Adapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : Listrectangle146RowModel) {
        onClickRecyclerListrectangle146(view, position, item)
      }
    }
    )
    viewModel.listrectangle146List.observe(this) {
      listrectangle146Adapter.updateData(it)
    }
    binding.auditionsThreeVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  fun onClickRecyclerListrectangle146(
    view: View,
    position: Int,
    item: Listrectangle146RowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "AUDITIONS_THREE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, AuditionsThreeActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}

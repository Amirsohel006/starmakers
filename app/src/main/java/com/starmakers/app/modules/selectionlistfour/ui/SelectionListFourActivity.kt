package com.starmakers.app.modules.selectionlistfour.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivitySelectionListFourBinding
import com.starmakers.app.modules.selectionlistfour.`data`.model.Listrectangle140RowModel
import com.starmakers.app.modules.selectionlistfour.`data`.viewmodel.SelectionListFourVM
import kotlin.Int
import kotlin.String
import kotlin.Unit

class SelectionListFourActivity :
    BaseActivity<ActivitySelectionListFourBinding>(R.layout.activity_selection_list_four) {
  private val viewModel: SelectionListFourVM by viewModels<SelectionListFourVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val listrectangle140Adapter =
    Listrectangle140Adapter(viewModel.listrectangle140List.value?:mutableListOf())
    binding.recyclerListrectangle140.adapter = listrectangle140Adapter
    listrectangle140Adapter.setOnItemClickListener(
    object : Listrectangle140Adapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : Listrectangle140RowModel) {
        onClickRecyclerListrectangle140(view, position, item)
      }
    }
    )
    viewModel.listrectangle140List.observe(this) {
      listrectangle140Adapter.updateData(it)
    }
    binding.selectionListFourVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  fun onClickRecyclerListrectangle140(
    view: View,
    position: Int,
    item: Listrectangle140RowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "SELECTION_LIST_FOUR_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SelectionListFourActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}

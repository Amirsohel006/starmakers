package com.starmakers.app.modules.selectionlisttwo.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivitySelectionListTwoBinding
import com.starmakers.app.modules.selectionlisttwo.`data`.model.Listrectangle141RowModel
import com.starmakers.app.modules.selectionlisttwo.`data`.viewmodel.SelectionListTwoVM
import kotlin.Int
import kotlin.String
import kotlin.Unit

class SelectionListTwoActivity :
    BaseActivity<ActivitySelectionListTwoBinding>(R.layout.activity_selection_list_two) {
  private val viewModel: SelectionListTwoVM by viewModels<SelectionListTwoVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val listrectangle140Adapter =
    Listrectangle140Adapter(viewModel.listrectangle140List.value?:mutableListOf())
    binding.recyclerListrectangle140.adapter = listrectangle140Adapter
    listrectangle140Adapter.setOnItemClickListener(
    object : Listrectangle140Adapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : Listrectangle141RowModel) {
        onClickRecyclerListrectangle140(view, position, item)
      }
    }
    )
    viewModel.listrectangle140List.observe(this) {
      listrectangle140Adapter.updateData(it)
    }
    binding.selectionListTwoVM = viewModel
    window.statusBarColor= ContextCompat.getColor(this,R.color.statusbar2)
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  fun onClickRecyclerListrectangle140(
    view: View,
    position: Int,
    item: Listrectangle141RowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "SELECTION_LIST_TWO_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SelectionListTwoActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}

package com.starmakers.app.modules.selectionlist.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivitySelectionListBinding
import com.starmakers.app.modules.selectionlist.`data`.model.SelectionListRowModel
import com.starmakers.app.modules.selectionlist.`data`.viewmodel.SelectionListVM
import com.starmakers.app.modules.selectionlistfour.ui.SelectionListFourActivity
import kotlin.Int
import kotlin.String
import kotlin.Unit

class SelectionListActivity :
    BaseActivity<ActivitySelectionListBinding>(R.layout.activity_selection_list) {
  private val viewModel: SelectionListVM by viewModels<SelectionListVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val selectionListAdapter =
    SelectionListAdapter(viewModel.selectionListList.value?:mutableListOf())
    binding.recyclerSelectionList.adapter = selectionListAdapter
    selectionListAdapter.setOnItemClickListener(
    object : SelectionListAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : SelectionListRowModel) {
        onClickRecyclerSelectionList(view, position, item)
      }
    }
    )
    viewModel.selectionListList.observe(this) {
      selectionListAdapter.updateData(it)
    }
    binding.selectionListVM = viewModel

    window.statusBarColor= ContextCompat.getColor(this,R.color.statusbar2)
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  fun onClickRecyclerSelectionList(
    view: View,
    position: Int,
    item: SelectionListRowModel
  ): Unit {
    when(view.id) {
      R.id.linearRowellipsethirtyfiveOne -> {
        onClickRecyclerSelectionListLinearRowellipsethirtyfiveOne(view, position, item)
      }
    }
  }

  fun onClickRecyclerSelectionListLinearRowellipsethirtyfiveOne(
    view: View,
    position: Int,
    item: SelectionListRowModel
  ): Unit {
    /** TODO As per your logic, Add constant type for item click.*/
    when(0) {
      0 -> {
        val destIntent = SelectionListFourActivity.getIntent(this, null)
        startActivity(destIntent)
      }
      1 -> {
        val destIntent = SelectionListFourActivity.getIntent(this, null)
        startActivity(destIntent)
      }
    }
  }

  companion object {
    const val TAG: String = "SELECTION_LIST_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SelectionListActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}

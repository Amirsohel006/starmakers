package com.starmakers.app.modules.selectionlistone.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivitySelectionListOneBinding
import com.starmakers.app.modules.auditions.ui.AuditionsActivity
import com.starmakers.app.modules.selectionlistone.`data`.model.Listrectangle107RowModel
import com.starmakers.app.modules.selectionlistone.`data`.viewmodel.SelectionListOneVM
import com.starmakers.app.modules.selectionlisttwo.ui.SelectionListTwoActivity
import kotlin.Int
import kotlin.String
import kotlin.Unit

class SelectionListOneActivity :
    BaseActivity<ActivitySelectionListOneBinding>(R.layout.activity_selection_list_one) {
  private val viewModel: SelectionListOneVM by viewModels<SelectionListOneVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val listrectangle106Adapter =
    Listrectangle106Adapter(viewModel.listrectangle106List.value?:mutableListOf())
    binding.recyclerListrectangle106.adapter = listrectangle106Adapter
    listrectangle106Adapter.setOnItemClickListener(
    object : Listrectangle106Adapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : Listrectangle107RowModel) {
        onClickRecyclerListrectangle106(view, position, item)
      }
    }
    )
    viewModel.listrectangle106List.observe(this) {
      listrectangle106Adapter.updateData(it)
    }
    binding.selectionListOneVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
    binding.txtAuditionsOne.setOnClickListener {
      val destIntent = AuditionsActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  fun onClickRecyclerListrectangle106(
    view: View,
    position: Int,
    item: Listrectangle107RowModel
  ): Unit {
    when(view.id) {
      R.id.btnSelectionListOne ->  {
        val destIntent = SelectionListTwoActivity.getIntent(this, null)
        startActivity(destIntent)
      }
    }
  }

  companion object {
    const val TAG: String = "SELECTION_LIST_ONE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SelectionListOneActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}

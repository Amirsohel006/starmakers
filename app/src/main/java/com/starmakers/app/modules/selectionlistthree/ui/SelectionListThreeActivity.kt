package com.starmakers.app.modules.selectionlistthree.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivitySelectionListThreeBinding
import com.starmakers.app.modules.auditions.ui.AuditionsActivity
import com.starmakers.app.modules.selectionlistfour.ui.SelectionListFourActivity
import com.starmakers.app.modules.selectionlistthree.`data`.model.Listrectangle106RowModel
import com.starmakers.app.modules.selectionlistthree.`data`.viewmodel.SelectionListThreeVM
import kotlin.Int
import kotlin.String
import kotlin.Unit

class SelectionListThreeActivity :
    BaseActivity<ActivitySelectionListThreeBinding>(R.layout.activity_selection_list_three) {
  private val viewModel: SelectionListThreeVM by viewModels<SelectionListThreeVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val listrectangle106Adapter =
    Listrectangle106Adapter(viewModel.listrectangle106List.value?:mutableListOf())
    binding.recyclerListrectangle106.adapter = listrectangle106Adapter
    listrectangle106Adapter.setOnItemClickListener(
    object : Listrectangle106Adapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : Listrectangle106RowModel) {
        onClickRecyclerListrectangle106(view, position, item)
      }
    }
    )
    viewModel.listrectangle106List.observe(this) {
      listrectangle106Adapter.updateData(it)
    }
    binding.selectionListThreeVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnParticipateInOtherAuditions.setOnClickListener {
      val destIntent = AuditionsActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  fun onClickRecyclerListrectangle106(
    view: View,
    position: Int,
    item: Listrectangle106RowModel
  ): Unit {
    when(view.id) {
      R.id.btnSelectionList ->  {
        val destIntent = SelectionListFourActivity.getIntent(this, null)
        startActivity(destIntent)
      }
    }
  }

  companion object {
    const val TAG: String = "SELECTION_LIST_THREE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SelectionListThreeActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}

package com.starmakers.app.modules.regstrationdetails.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityRegstrationDetailsBinding
import com.starmakers.app.modules.frametwentyfour.ui.FrameTwentyfourActivity
import com.starmakers.app.modules.regstrationdetails.`data`.model.Listellipsetwentysix2RowModel
import com.starmakers.app.modules.regstrationdetails.`data`.model.Listpaypalone2RowModel
import com.starmakers.app.modules.regstrationdetails.`data`.viewmodel.RegstrationDetailsVM
import kotlin.Int
import kotlin.String
import kotlin.Unit

class RegstrationDetailsActivity :
    BaseActivity<ActivityRegstrationDetailsBinding>(R.layout.activity_regstration_details) {
  private val viewModel: RegstrationDetailsVM by viewModels<RegstrationDetailsVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val listpaypaloneAdapter =
    ListpaypaloneAdapter(viewModel.listpaypaloneList.value?:mutableListOf())
    binding.recyclerListpaypalone.adapter = listpaypaloneAdapter
    listpaypaloneAdapter.setOnItemClickListener(
    object : ListpaypaloneAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : Listpaypalone2RowModel) {
        onClickRecyclerListpaypalone(view, position, item)
      }
    }
    )
    viewModel.listpaypaloneList.observe(this) {
      listpaypaloneAdapter.updateData(it)
    }
    val listellipsetwentysixAdapter =
    ListellipsetwentysixAdapter(viewModel.listellipsetwentysixList.value?:mutableListOf())
    binding.recyclerListellipsetwentysix.adapter = listellipsetwentysixAdapter
    listellipsetwentysixAdapter.setOnItemClickListener(
    object : ListellipsetwentysixAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item :
      Listellipsetwentysix2RowModel) {
        onClickRecyclerListellipsetwentysix(view, position, item)
      }
    }
    )
    viewModel.listellipsetwentysixList.observe(this) {
      listellipsetwentysixAdapter.updateData(it)
    }
    binding.regstrationDetailsVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
    binding.btnPayAndRegisterOne.setOnClickListener {
      val destIntent = FrameTwentyfourActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  fun onClickRecyclerListpaypalone(
    view: View,
    position: Int,
    item: Listpaypalone2RowModel
  ): Unit {
    when(view.id) {
    }
  }

  fun onClickRecyclerListellipsetwentysix(
    view: View,
    position: Int,
    item: Listellipsetwentysix2RowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "REGSTRATION_DETAILS_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, RegstrationDetailsActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}

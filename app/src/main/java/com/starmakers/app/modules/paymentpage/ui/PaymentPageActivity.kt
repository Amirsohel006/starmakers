package com.starmakers.app.modules.paymentpage.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityPaymentPageBinding
import com.starmakers.app.modules.frame317.ui.Frame317Activity
import com.starmakers.app.modules.paymentpage.`data`.model.ListellipsetwentysixRowModel
import com.starmakers.app.modules.paymentpage.`data`.model.ListpaypaloneRowModel
import com.starmakers.app.modules.paymentpage.`data`.viewmodel.PaymentPageVM
import kotlin.Int
import kotlin.String
import kotlin.Unit

class PaymentPageActivity : BaseActivity<ActivityPaymentPageBinding>(R.layout.activity_payment_page)
    {
  private val viewModel: PaymentPageVM by viewModels<PaymentPageVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val listpaypaloneAdapter =
    ListpaypaloneAdapter(viewModel.listpaypaloneList.value?:mutableListOf())
    binding.recyclerListpaypalone.adapter = listpaypaloneAdapter
    listpaypaloneAdapter.setOnItemClickListener(
    object : ListpaypaloneAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : ListpaypaloneRowModel) {
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
      override fun onItemClick(view:View, position:Int, item : ListellipsetwentysixRowModel) {
        onClickRecyclerListellipsetwentysix(view, position, item)
      }
    }
    )
    viewModel.listellipsetwentysixList.observe(this) {
      listellipsetwentysixAdapter.updateData(it)
    }
    binding.paymentPageVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnPayAndDonate.setOnClickListener {
      val destIntent = Frame317Activity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  fun onClickRecyclerListpaypalone(
    view: View,
    position: Int,
    item: ListpaypaloneRowModel
  ): Unit {
    when(view.id) {
    }
  }

  fun onClickRecyclerListellipsetwentysix(
    view: View,
    position: Int,
    item: ListellipsetwentysixRowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "PAYMENT_PAGE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, PaymentPageActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}

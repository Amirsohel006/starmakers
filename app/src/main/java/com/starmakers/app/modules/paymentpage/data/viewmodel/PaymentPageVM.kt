package com.starmakers.app.modules.paymentpage.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.paymentpage.`data`.model.ListellipsetwentysixRowModel
import com.starmakers.app.modules.paymentpage.`data`.model.ListpaypaloneRowModel
import com.starmakers.app.modules.paymentpage.`data`.model.PaymentPageModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class PaymentPageVM : ViewModel(), KoinComponent {
  val paymentPageModel: MutableLiveData<PaymentPageModel> = MutableLiveData(PaymentPageModel())

  var navArguments: Bundle? = null

  val listpaypaloneList: MutableLiveData<MutableList<ListpaypaloneRowModel>> =
      MutableLiveData(mutableListOf())

  val listellipsetwentysixList: MutableLiveData<MutableList<ListellipsetwentysixRowModel>> =
      MutableLiveData(mutableListOf())
}

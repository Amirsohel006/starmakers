package com.starmakers.app.modules.financialoverview.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starmakers.app.modules.financialoverview.`data`.model.FinancialOverviewModel
import com.starmakers.app.modules.financialoverview.`data`.model.GridrectangletenRowModel
import com.starmakers.app.modules.financialoverview.`data`.model.SpinnerGroup122Model
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class FinancialOverviewVM : ViewModel(), KoinComponent {
  val financialOverviewModel: MutableLiveData<FinancialOverviewModel> =
      MutableLiveData(FinancialOverviewModel())

  var navArguments: Bundle? = null

  val spinnerGroup122List: MutableLiveData<MutableList<SpinnerGroup122Model>> = MutableLiveData()

  val gridrectangletenList: MutableLiveData<MutableList<GridrectangletenRowModel>> =
      MutableLiveData(mutableListOf())
}

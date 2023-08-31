package com.starmakers.app.modules.financialoverview.`data`.model

import com.starmakers.app.R
import com.starmakers.app.appcomponents.di.MyApp
import kotlin.String

data class FinancialOverviewModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtRahul: String? = MyApp.getInstance().resources.getString(R.string.lbl_rahul)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGroup203: String? = MyApp.getInstance().resources.getString(R.string.msg_finance_overvie)

)

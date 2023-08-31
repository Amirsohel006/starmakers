package com.starmakers.app.modules.paymentpage.`data`.model

import com.starmakers.app.R
import com.starmakers.app.appcomponents.di.MyApp
import kotlin.String

data class ListellipsetwentysixRowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtNetbanking: String? = MyApp.getInstance().resources.getString(R.string.lbl_netbanking)

)
